package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.fwd.pmap.scheduler.SchedulerConfig;

public class Main {
    static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @SuppressWarnings({ "unused", "resource" })
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfig.class);
    }
}