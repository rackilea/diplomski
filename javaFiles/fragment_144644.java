package com.test.practice;

import java.util.Scanner;

public class Bodymass {

public static void main(String[] args) {
     Scanner scan=new Scanner(System.in);
        String[] studentName= new String[2];
        System.out.println("Please enter the Names of 2 students");
        // This "i" is your counter.
        for (int i=0; i< studentName.length; i++) {
           System.out.print("Enter the student name at postion "+i+". "); 
           studentName[i]= scan.nextLine();
        }

        System.out.println("Please enter the Weight of 2 students");
        Scanner scan1= new Scanner(System.in);
        int[] studentWeight= new int[2];

        for(int i=0; i<studentWeight.length; i++) {
            System.out.print("weight of student at position "+i+" "); 
            studentWeight[i]= scan.nextInt();
            }
    }
}