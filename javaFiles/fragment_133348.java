package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String first = "file1.txt";
        String second = "file2.txt";
        BufferedReader fBr = new BufferedReader(new FileReader(first));
        BufferedReader sBr = new BufferedReader(new FileReader(second));

        ArrayList<String> strings = new ArrayList<String>();

        while ((first = fBr.readLine()) != null) {
            strings.add(first);
        }
        fBr.close();

        while ((second = sBr.readLine()) != null) {
            if (strings.contains(second)) {
                System.out.println(second);
            }
        }
        sBr.close();
    }
}