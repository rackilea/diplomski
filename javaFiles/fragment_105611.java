package framework.root.service;

import framework.root.service.FrameworkHelloService.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "framework", fallback = HelloServiceFallback.class)
public interface FrameworkHelloService {
    @GetMapping("/api/hello")
    public String hello();

    @GetMapping("/api/exception")
    public void exception();

    @GetMapping("/none")
    public String none();

    @Component
    class HelloServiceFallback implements FrameworkHelloService {
        @Override
        public String hello() {
            return null;
        }

        @Override
        public void exception() { }

        @Override
        public String none() {
            return "Fallback!";
        }
    }
}