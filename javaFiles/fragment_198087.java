package com.test;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.InitializingBean;

public class ServiceManager implements InitializingBean {

    private Collection<Service> services;

    HashMap<ServiceKey, Service> serviceMap = new HashMap<ServiceKey, Service>();

    public Collection<Service> getServices() {
        return services;
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }

    public HashMap<ServiceKey, Service> getServiceMap() {
        return serviceMap;
    }

    public void afterPropertiesSet() throws Exception {
        for (Service service : services) {
            serviceMap.put(service.getKey(), service);
        }
    }
}