package com.krovi.compscan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAnotherClient
{
    private MyInterface impl;

    protected MyAnotherClient()
    {

    }

    public MyInterface getImpl()
    {
        return impl;
    }

    public void setImpl(
        MyInterface impl)
    {
        this.impl = impl;
    }

    public void clientMethod()
    {
        impl.method();
    }

    public static void main(
        String[] args)
    {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("classpath:META-INF/compscan.xml");
        MyAnotherClient client =
            context.getBean(MyAnotherClient.class);
        client.clientMethod();
    }
}