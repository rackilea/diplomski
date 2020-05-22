package com.ct.test.kafka;

import java.util.Date;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {

    public static void main(String[] args) {
        String topic = args[0];

        Properties props = new Properties();
        props.put("metadata.broker.list", "{Hostname}:6667");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");
        props.put("security.protocol", "PLAINTEXTSASL");

        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);

        for (int i = 0; i < 10; i++){
            producer.send(new KeyedMessage<String, String>(topic, "Test Date: " + new Date()));
        }
    }
}