package com.levo.so.maprelated;

import java.util.HashMap;
import java.util.Map;

public class HexMapSuccessDemo {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        System.out.println(map.get('5'));
    }

}