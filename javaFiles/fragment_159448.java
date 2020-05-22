package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<>();
        map.put("Pizza", 20);
        map.put("Spaghetti", 20);
        map.put("Ice Cream", 20);

        for (String s : map.keySet())
            System.out.println(s);
    }
}