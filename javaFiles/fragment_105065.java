package com.test.java;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Multimap<String, Multimap<String,Integer>>  map =  ArrayListMultimap.create();

        Multimap<String,Integer> m = ArrayListMultimap.create();

        //put some values
        m.put("value1", 1);
        m.put("value2", 2);
        m.put("value3", 3);

        map.put("one", m);

        for (Object value1 : map.values()) { 
            for (Object value2 : ((Multimap<String,Integer>)value1).values()) { 
                System.out.println((Integer)value2);
            }
        }
    }

}