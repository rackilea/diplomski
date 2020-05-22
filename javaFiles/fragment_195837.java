package com.KingAm.HelloWorld;

import javax.xml.ws.Endpoint;
//import helloWorldImpl;

public class helloWorldPublisher {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/ws/helloWorld", new helloWorldImpl());
           System.out.println("Hello World Server is published!");

    }

}