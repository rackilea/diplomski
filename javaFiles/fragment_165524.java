open class SecurityInitializer : AbstractSecurityWebApplicationInitializer()

@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.antMatcher("/docs/swagger/v2/api-docs").addFilter(myFilter())
    }

    open fun myFilter() = object : FilterSecurityInterceptor() {
        override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

            if (do your stuff here) {
                chain!!.doFilter(request,response) // continue with other filters
            } else {
                super.doFilter(request, response, chain) // filter this request
            }
        }
    }
}