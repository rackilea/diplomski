package demo;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;


public class CustomConfigListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            for(PropertySource<?> source : ((ApplicationEnvironmentPreparedEvent) event).getEnvironment().getPropertySources()){
                if(source.getName().equals("applicationConfigurationProperties")){              
                    if (source instanceof EnumerablePropertySource) {
                        for(String name : ((EnumerablePropertySource) source).getPropertyNames()){
                            System.out.println(name+" :: "+ ((EnumerablePropertySource) source).getProperty(name));
                        }
                    }
                }
            }           
        }       
    }

}