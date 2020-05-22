package com.krovi.compscan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClient
{
    private MyInterface myInterface;

    public MyClient(MyInterface i)
    {
        this.myInterface = i;
    }

    public void clientMethod()
    {
        myInterface.method();
    }

    // Main method to test.    
    public static void main(
        String[] args)
    {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("classpath:META-INF/compscan.xml");
        MyClient client =
            context.getBean(MyClient.class);
        client.clientMethod();
    }
}