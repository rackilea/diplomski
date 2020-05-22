package org.springframework.security.web.access.expression; //First part of the trick!

import foo.bar.example.services.security.CustomAccessDecisionManager; 

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.webflow.security.SecurityFlowExecutionListener;
import org.springframework.webflow.security.SecurityRule;

/**
 * Force Spring WebFlow Security listener to use expression!
 * 
 * @author roberto.gabrieli
 */
public class CustomSecurityFlowExecutionListener<T > extends SecurityFlowExecutionListener
{

    /**
     * Convert SecurityRule into a form understood by Spring Security Force the usage of WebExpressionConfigAttribute!
     * 
     * @param rule
     *            the rule to convert
     * @return list of ConfigAttributes for Spring Security
     */
    @Override
    @SuppressWarnings("deprecation")
    protected Collection<ConfigAttribute> getConfigAttributes(SecurityRule rule)
    {
        // Get Access Decision Manager to find if has my expression handler
        AccessDecisionManager adm = getAccessDecisionManager();

        ExpressionParser ep = null;
        //  Check if is my CustomAccessDecisionManager so I can use my expressions
        if ( adm instanceof CustomAccessDecisionManager )
        {
            ep = ((CustomAccessDecisionManager) adm).getWebSecurityExpressionHandler().getExpressionParser();
        }

        List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
        for ( String attribute : rule.getAttributes() )
        {
            if ( ep != null )
                // this will end the trick with fireworks!
                configAttributes.add(new WebExpressionConfigAttribute(ep.parseExpression(attribute)));
            else
                configAttributes.add(new SecurityConfig(attribute));
        }
        return configAttributes;
    }
}