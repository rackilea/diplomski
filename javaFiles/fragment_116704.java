package com.stackoverflow.solutionmaker;

public class Aclass {

    public Aclass(){
        somePrivMethod();
    }

    public void aMethod(){
        System.out.println("Can see me from anywehre bcoz I am public");
    }

    private void somePrivMethod(){
        System.out.println("Cannot find me from anywhere because I am private t Aclass");
    }

}