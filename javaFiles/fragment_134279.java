package com.something;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.util.DefaultPropertiesPersister;

public class MyPropertiesPersister extends DefaultPropertiesPersister {
    protected String unescape(String str)
    {
        return StringEscapeUtils.unescapeJava(str);
    }    
}