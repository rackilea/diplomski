package com.project.services.configuration;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Test Service Config", description = "Test Service Configuration.")
public @interface TestServiceConfig {

    @AttributeDefinition(name = "url", description = "Provide URL for localhost")
    String url() default "http://localhost:4502";
}