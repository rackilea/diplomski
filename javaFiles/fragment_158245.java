package org.example;

import org.apache.camel.builder.RouteBuilder;

public class ConsumeRest extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost:5000/").component("http");
        from("timer:scheduler?period=6000")
                .to("rest:get:hello/");
    }
}