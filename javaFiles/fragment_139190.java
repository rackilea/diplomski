import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public TaskScheduler taskScheduler() {
        final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        return scheduler;
    }


    @Scheduled(fixedDelay = 2 * 1000L, initialDelay = 3 * 1000L)
    public void scheduled1() throws InterruptedException {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled1");
        Thread.sleep(1000);
    }

    @Scheduled(fixedDelay = 3 * 1000L, initialDelay = 3 * 1000L)
    public void scheduled2() throws InterruptedException {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled2");
        Thread.sleep(1000);
    }
}