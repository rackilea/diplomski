package com.massaiolir.simple.iface;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Main {
    public static void main(String[] args) throws Exception {
        Serializer serial = new Persister();
        ResC resc = serial.read(ResC.class, new File("data/testdata.xml"));

        System.out.println(" == Printing out all of the error text. == ");
        System.out.println(resc.getErrorText());
        System.out.println(resc.conRes.getErrorText());
        System.out.println(resc.conRes.conList.getErrorText());
        for (Con con : resc.conRes.conList.cons) {
            System.out.println(con.getErrorText());
        }
        System.out.println(" == Finished printing out all of the error text. == ");
    }
}