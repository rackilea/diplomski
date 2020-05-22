package com.project.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.project.services.configuration.TestServiceConfig;
import com.project.services.TestService;

@Component(service = TestService.class, name = "TestService", immediate = true)
@Designate(ocd = TestServiceConfig.class)
public class TestServiceImpl implements TestService {

    private String url;

    @Override
    public String getTitle() {
        return "Test Service Title";
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Activate
    protected void activate(TestServiceConfig testServiceConfig) {
        url = testServiceConfig.url();
    }

}