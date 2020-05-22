package com.levo.so.maprelated;

import java.util.HashMap;
import java.util.Map;

public class HexMapFailDemo {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('1', 0001);
        map.put('2', 0010);
        map.put('3', 0011);
        map.put('4', 0100);
        map.put('5', 0101);
        map.put('6', 0110);
        map.put('7', 0111);
        map.put('8', 1000);
        map.put('9', 1001);
        map.put('A', 1010);
        map.put('B', 1011);
        map.put('C', 1100);
        map.put('D', 1101);
        map.put('E', 1110);
        map.put('F', 1111);

        System.out.println(map.get('5'));
        System.out.println("Octal 101 = 8^2 + 1 = " + (8*8 + 1));
    }

}