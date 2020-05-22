package assignment9;

import java.util.Scanner;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

public class Scheduler {
static Scanner kbd = new Scanner(System.in);

/**
 * Writes a program that allows students to schedule appointments at either
 * 1, 2, 3, 4, 5, or 6 o’clock p. m.
 * 
 * @param args
 */
public static void main(String[] args) {

    String[] appointmentTime = new String[7];

    int time;
    String name;
    int temp = 1;

    try {
        do {

            System.out.println("\nEnter your name");
            name = kbd.next();

            System.out.println("Which time slot would you like to chose?");
            time = kbd.nextInt();

            if (appointmentTime[time] == null && time > 0 && time < 7) {
                appointmentTime[time] = name;
                System.out.println(time + " is added to slot "
                        + appointmentTime[time]);

            } else if (appointmentTime[time] != null) {
                throw new TimeInUseException();

            } else if (time < 0 || time > 7) {
                throw new InvalidTimeException();
            }
            temp++;
        } while (temp < 7);

        // Final stage: printing
        System.out.println("Schedule:");
        for (int i = 1; i < 7; i++) {
        System.out.println((i) + "PM: \t"
        + appointmentTime[i].toString());}

    } catch (InvalidTimeException e) {
        System.out.println(e.getMessage());
        System.out.println("Enter another time");
    } catch (TimeInUseException ex) {
        System.out.println(ex.getMessage());
        System.out.println("Enter another time");
    } catch (ArrayIndexOutOfBoundsException ex1) {
        System.out.println(ex1.getMessage());
    } catch (NullPointerException ex2) {
        System.out.println(ex2.getMessage());
    }

}

}