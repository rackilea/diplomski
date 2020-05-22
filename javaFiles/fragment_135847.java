package com.test;

import java.applet.Applet;
import java.awt.*;

public class AppletTest extends Applet {
    {
        System.out.println("I m Anonymous block");
    }

    static {
        System.out.println("I m static block");
    }

    public AppletTest()
    {
        System.out.println("I m constructor");
    }

    public void init()
    {
        System.out.println("init");
    }

    public void start()
    {
        System.out.println("start");
    }

    public void stop()
    {
        System.out.println("stop");   
    }

    public void destroy()
    {
        System.out.println("destory");   
    }

    public void paint(Graphics g)
    {
        g.drawString("test Applet",10,10);
    }
}