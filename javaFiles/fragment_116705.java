package com.stackoverflow.solutionmaker;

public class StackOverflowSolutionsRunner {

    public static void main(String[] args) {

        Aclass aClass = new Aclass(); // It will display"Cannot find me from anywhere because I am private t Aclass"

        aClass.aMethod(); // It will display "Can see me from anywehre bcoz I am public

        aClass.somePrivMethod(); // Will throw a compile-time error


    }
}