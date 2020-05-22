package my.app.entity.projection;

import org.springframework.data.rest.core.config.Projection;
...

@Projection(name = "serviceDetails", types = Service.class)
public interface ServiceDetails {   
    String getKey();
    String getName();   
    ServiceType getType();
    ServiceGroup getGroup();
    Person getOwner();
    List<ServiceInstance> getServiceInstances();    
    List<DocLink> getDocLinks();
    String getPlatform();
}