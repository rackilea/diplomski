package main;
public class Main {
public static void main(String[] args) {
    for (int counter=2; counter<=40; counter+=2) {
       System.out.println(counter);
    }
    System.out.println("For loop complete.");

    int counter = 1;
    int loopExecCounter = 0;
    while (counter <= 500) {
        loopExecCounter = loopExecCounter + 1;
        System.out.println(counter);
    counter++;
    }
System.out.print(loopExecCounter);
 }
}