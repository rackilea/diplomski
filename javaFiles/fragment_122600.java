package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DBApp {
    public enum PowerCatagory{SpecialPower,Weapon,Machines}

    public static void main(String[] args) {
        SpringApplication.run(DBApp.class,args);

    }
}