import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import net.app.locale.service.UserService;

@Configuration
public class ApplicationLocaleResolver extends SessionLocaleResolver {
    @Autowired
    UserService userService;

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String userName = securityContext.getAuthentication().getName();
        String localeOption = userService.getUsersPreferedLocaleOption(userName);
        Locale userLocale = Locale.forLanguageTag(localeOption);
        return userLocale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        super.setLocale(request, response, locale);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        String userName = securityContext.getAuthentication().getName();
        userService.saveUsersPreferedLocaleOption(userName, locale);
    }
}