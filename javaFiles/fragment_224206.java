package com.stackoverflow.q53757986;

import static org.junit.Assert.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@SuppressWarnings("javadoc")
public class CamelJmsTest {

    static final String ACTIVE_MQ_HOST = "vm://activeMQ?broker.persistent=false";

    /** The Constant SPRING_CLASS_RULE. */
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    /** The spring method rule. */
    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @BeforeClass
    public static void setActiveMQ() {
        System.setProperty("amq.endpoint", ACTIVE_MQ_HOST);
    }

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    RouteConfigBuilder routeConfig;

    @Autowired
    RouteBuilder routeBuilder;

    @Test
    public void postJmsMessage() {

        assertEquals("java", this.routeConfig.source);
        assertEquals("java", this.routeBuilder.source);

        this.jmsTemplate.send("queue/test", (MessageCreator) session -> session.createTextMessage("Hello World"));

        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
            }
        } catch (Exception ignored) {}
    }

    @Configuration
    @ImportResource("classpath:production-beans-camel-jms.xml")
    static class TestConfig {

        @Primary
        @Bean
        public JmsTemplate jmsTemplate() {
            return new JmsTemplate(new ActiveMQConnectionFactory("", "", ACTIVE_MQ_HOST));
        }

        @Primary
        @Bean // ideally i just want this bean to override the bean imported from the xml config
        public RouteConfigBuilder routeConfig2() {
            return new RouteConfigBuilder("java");
        }

        @Primary
        @Bean
        public RouteBuilder routeBuilder2() {
            return new RouteBuilder(routeConfig2(), "java");
        }
    }
    }