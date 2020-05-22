package com.java;

public class InvalidValue {
    private int i = giveMeJ();
    private int j = 20;

    // Default Constructor
    public InvalidValue() {
        super();
        // Second Print: inside Constructor[i= 0, j= 20]
        System.out.println("inside Constructor[i= " + i + ", j= " + j + "]");
    }

    private int giveMeJ() {
        // First Print: inside giveMeJ[i= 0, j= 0]
        System.out.println("inside giveMeJ[i= " + i + ", j= " + j + "]");
        return j;
    }

    public static void main(String[] args) {
        // Third Print: i: 0
        System.out.println("i: " + new InvalidValue().i);
    }
}