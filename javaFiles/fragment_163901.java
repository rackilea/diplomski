package com.example.myapp.core.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Globals {
    public static final String CORE_CONFIGURATION_BASENAME = "com.example.myapp.core.configuration";
    private static final String DOMAIN_PACKAGE_KEY = "myapp.domain.package.name";
    public static final String DOMAIN_PACKAGE; //we leave it uninitialized on purpose.

    static {
        ResourceBundle bundle = PropertyResourceBundle(CORE_CONFIGURATION_BASENAME);
        DOMAIN_PACKAGE = bundle.getString(DOMAIN_PACKAGE_KEY);
    }
}