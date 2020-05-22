import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean

class CustomRememberMeAuthenticationFilter extends GenericFilterBean implements ApplicationEventPublisherAware {

    def authenticationManager
    def eventPublisher
    def customService
    def rememberMeServices
    def springSecurityService

    //make certain that we've specified our beans
    void afterPropertiesSet() {
        assert authenticationManager != null, 'authenticationManager must be specified'
        assert customService != null, 'customService must be specified'
        assert rememberMeServices != null, 'rememberMeServices must be specified'
    }

    void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req
        HttpServletResponse response = (HttpServletResponse) res

        if (SecurityContextHolder.getContext().getAuthentication() == null) {           
            Authentication auth
            try {
                auth = customService.getUsernamePasswordAuthenticationToken(request)
                if (auth != null) {
                    springSecurityService.reauthenticate(auth.getPrincipal(), auth.getCredentials())
                    logger.debug("SecurityContextHolder populated with auth: '"
                        + SecurityContextHolder.getContext().getAuthentication() + "'")
                    onSuccessfulAuthentication(request, response, SecurityContextHolder.getContext().getAuthentication())
                } else {
                    logger.debug('customService did not return an authentication from the request')
                }
            } catch (AuthenticationException authenticationException) {
                logger.warn("SecurityContextHolder not populated with auth, as "
                    + "springSecurityService rejected Authentication returned by customService: '"
                    + auth + "'", authenticationException)
                onUnsuccessfulAuthentication(request, response, auth)
            } catch(e) {
                logger.warn("Unsuccessful authentication in customRememberMeAuthenticationFilter", e)
                onUnsuccessfulAuthentication(request, response, auth)
            }
        } else {
            logger.debug("SecurityContextHolder not populated with auth, as it already contained: '"
                + SecurityContextHolder.getContext().getAuthentication() + "'")
        }
        chain.doFilter(request, response)
    }

    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) {
        //sets the rememberMe cookie, but cannot call "loginSuccess" because that filters out requests
        //that don't set the rememberMe cookie, like this one
        rememberMeServices.onLoginSuccess(request, response, authResult)
    }

    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        //clear the rememberMe cookie
        rememberMeServices.loginFail(request, response)
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher
    }
}