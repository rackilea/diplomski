package io.github.mweirauch.micrometered.eval;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.Timer.Sample;

@Configuration
@EnableAspectJAutoProxy
public class TimingStuff {

    @Service
    static class MyService {

        @Autowired
        private MeterRegistry registry;

        public void helloManual() {
            // you can keep a ref to this; ok to call multiple times, though
            Timer timer = Timer.builder("myservice").tag("method", "manual").register(registry);

            // manually do the timing calculation
            long start = System.nanoTime();
            doSomething();
            timer.record(System.nanoTime() - start, TimeUnit.NANOSECONDS);
        }

        public void helloSupplier() {
            Timer timer = Timer.builder("myservice").tag("method", "supplier").register(registry);

            // execution of the method is timed internally
            timer.record(() -> doSomething());
        }

        public void helloSample() {
            Timer timer = Timer.builder("myservice").tag("method", "sample").register(registry);

            // records time taken between Sample creation and registering the
            // stop() with the given Timer
            Sample sample = Timer.start(registry);
            doSomething();
            sample.stop(timer);
        }

        // TimedAspect adds "class" and "method" tags
        @Timed(value = "myservice.aspect")
        public void helloAspect() {
            doSomething();
        }

        private void doSomething() {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                //
            }
        }

    }

    @Autowired
    private MyService myService;

    @Bean
    TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Scheduled(fixedRate = 1000)
    public void postConstruct() {
        myService.helloManual();
        myService.helloSupplier();
        myService.helloSample();
        myService.helloAspect();
    }

}