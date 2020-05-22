package com.sample.service;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Green");
        list.add("Orange");
        list.add("Red");
        list.add("Black");
        list.add("White");

        boolean test = list.contains("Red");
        System.out.println(test);

    }
}