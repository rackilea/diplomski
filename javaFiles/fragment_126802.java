package com.abc.wls.security.providers.authentication;

import java.util.HashMap;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

import weblogic.management.security.ProviderMBean;
import weblogic.security.provider.PrincipalValidatorImpl;
import weblogic.security.spi.AuthenticationProviderV2;
import weblogic.security.spi.IdentityAsserterV2;
import weblogic.security.spi.PrincipalValidator;
import weblogic.security.spi.SecurityServices;

public class WLAuthenticationProviderImpl implements AuthenticationProviderV2 {
    private String description = "MyOwn WLAuthentication Provider";
    // private SimpleSampleAuthenticatorDatabase database;
    private LoginModuleControlFlag controlFlag;

    public void initialize(ProviderMBean mbean, SecurityServices services) {
        System.out.println("WLAuthenticationProviderImpl.initialize");
        // WLAuthenticationProviderMBean mbean =
        // (WLAuthenticationProviderMBean) mbean;

        // SimpleSampleAuthenticatorMBean myMBean =
        // (SimpleSampleAuthenticatorMBean) mbean;
        // description = myMBean.getDescription() + "\n" + myMBean.getVersion();
        // database = new SimpleSampleAuthenticatorDatabase(myMBean);
        // String flag = myMBean.getControlFlag();
        /*
         * if (flag.equalsIgnoreCase("REQUIRED")) { controlFlag =
         * LoginModuleControlFlag.REQUIRED; } else if
         * (flag.equalsIgnoreCase("OPTIONAL")) { controlFlag =
         * LoginModuleControlFlag.OPTIONAL; } else if
         * (flag.equalsIgnoreCase("REQUISITE")) { controlFlag =
         * LoginModuleControlFlag.REQUISITE; } else if
         * (flag.equalsIgnoreCase("SUFFICIENT")) { controlFlag =
         * LoginModuleControlFlag.SUFFICIENT; } else { throw new
         * IllegalArgumentException("invalid flag value" + flag); }
         */
    }

    public String getDescription() {
        System.out.println("WLAuthenticationProviderImpl.getDescription");
        return description;
    }

    public void shutdown() {
        System.out.println("WLSecurityProviderImpl.shutdown");
    }

    private AppConfigurationEntry getConfiguration(HashMap options) {
        System.out.println("WLAuthenticationProviderImpl.getConfiguration");
        if (options == null)
            options = new HashMap<>();
        options.put("app-unique-name", "xyz-ui");
        // return new
        // AppConfigurationEntry("examples.security.providers.authentication.Simple.Simple.SampleLoginModuleImpl",
        // controlFlag, options);
        return new AppConfigurationEntry("com.abc.wls.security.providers.authentication.WLServerLoginModule", LoginModuleControlFlag.REQUIRED, options);
    }

    public AppConfigurationEntry getLoginModuleConfiguration() {
        System.out.println("WLAuthenticationProviderImpl.getLoginModuleConfiguration");
        HashMap options = new HashMap();
        return getConfiguration(options);
    }

    public AppConfigurationEntry getAssertionModuleConfiguration() {
        System.out.println("WLAuthenticationProviderImpl.getAssertionModuleConfiguration");
        HashMap options = new HashMap();
        options.put("IdentityAssertion", "true");
        return getConfiguration(options);
    }

    public PrincipalValidator getPrincipalValidator() {
        return new PrincipalValidatorImpl();
    }

    public IdentityAsserterV2 getIdentityAsserter() {
        return null;
    }

}