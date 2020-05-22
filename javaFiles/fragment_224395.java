package com.krovi.compscan;

import org.springframework.stereotype.Component;

@Component
public class MyImpl implements MyInterface
{
    public void method()
    {
        System.out.println("Method definition in the implementation");
    }
}