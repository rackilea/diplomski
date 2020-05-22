package me.chris.pizzacost;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

public static Person[] people; //put the declaration here. as a class member.    

public static void main(String[] args) {

    DecimalFormat f = new DecimalFormat("##.00");
    Scanner scan = new Scanner(System.in);

   // static Person[] people; (get rid of this)

    System.out.println("Welcome to Pizza Cost!\nTo start, how many people are in on this order?");

    people = new Person[scan.nextInt()];

    scan.nextLine();
    System.out.println("Type their names, pressing ENTER between names.");
    for (int x = 0; x<people.length; x++) {
        //System.out.println("ran");
        people[x] = new Person();
        people[x].name = scan.nextLine();
        //System.out.println("hit the end");
    }
  }
}