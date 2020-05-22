import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("Application started");
        String path = databaseUrl.replace("jdbc:h2:file:", "");
        System.out.println(path);
        File dbFile = new File(path);
        if (!dbFile.exists()) {
            String sql = "etc";
        }
    }

}