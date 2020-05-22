package main.application;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {25, 30, 35};

        int idx = new Random().nextInt(intArray.length);
        String random = "Value is " + (intArray[idx]);

        System.out.println(random);
    }   
}