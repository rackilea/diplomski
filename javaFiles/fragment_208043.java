import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public AccessDecisionManager accessDecisionManager() {

        logger.debug("accessDecisionManager config...");

        Map<String, AccessDecisionStrategy> strategyMap = new HashMap<String, AccessDecisionStrategy>();

        strategyMap.put("GetByOwner", new GetByOwnerStrategy());

        return new MethodSecurityAccessDecisionManager(strategyMap);
    }

}