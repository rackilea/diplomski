package com.mumz.test.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentScannerApp {
    private List<Student> students = new ArrayList<Student>();
    public static void main(String[] args) {

        StudentScannerApp studentScannerApp = new StudentScannerApp();
        //This scanner we will use for reading data from input stream
        Scanner inputStream = new Scanner(System.in);

        System.out.println("Enter First Name");
        String firstName = inputStream.nextLine();
        System.out.println("Enter Last Name");
        String lastName = inputStream.nextLine();
        studentScannerApp.addStudent(firstName, lastName);

        System.out.println("Enter Another student details");
        System.out.println("Enter First Name");
        firstName = inputStream.nextLine();
        System.out.println("Enter Last Name");
        lastName = inputStream.nextLine();
        studentScannerApp.addStudent(firstName, lastName);

        System.out.println(studentScannerApp.students);
    }

    private void addStudent(String firstName, String lastName){
        Student student = new Student(firstName, lastName);
        students.add(student);
    }
}