package com.kb;

public class Whatever {
    private int myVar = initializeInstanceVariable();

    protected  int initializeInstanceVariable() {
        return 10;
    }

    public static void main(String[] args) {
        Whatever myVar2 = new Whatever();
        myVar2.initializeInstanceVariable();

        System.out.println(myVar2.myVar);

        Whatever var = new AAA();
        System.out.println(var.myVar);
    }
}

class AAA extends Whatever{
    @Override
    protected int initializeInstanceVariable() {
        return 20;
    }
}