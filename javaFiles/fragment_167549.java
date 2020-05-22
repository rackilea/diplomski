import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
public class MyPojo {

    @Autowired
    private ConfigurableEnvironment env;

    private Map<String, Object> schedules;

    @PostConstruct
    public void properties() {
        Object propSourceObj = env.getPropertySources().get("applicationConfig: [classpath:/application.properties]");
        if (propSourceObj instanceof OriginTrackedMapPropertySource) {
            OriginTrackedMapPropertySource propSource = (OriginTrackedMapPropertySource) propSourceObj;
            setSchedules(propSource.getSource());
        }
        System.out.println("Schedules: " + getSchedules());

    }

    public Map<String, Object> getSchedules() {
        return schedules;
    }

    public void setSchedules(Map<String, Object> schedules) {
        this.schedules = schedules;
    }

}