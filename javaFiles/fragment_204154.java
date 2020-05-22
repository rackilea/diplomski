package com.example.logging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LogToFiles {

    public static void main(String[] args) throws FileNotFoundException {
        System.setOut(new PrintStream("example.log"));
        System.setErr(new PrintStream(new FileOutputStream("example.err"), true));

        System.out.println("System.out example");
        System.err.println("System.err example");
    }

}