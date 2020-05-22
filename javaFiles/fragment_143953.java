package com.adi.search.string;

import java.io.*;
import java.util.*;

public class SearchString {

    public static void main(String[] args) {

        String inputFileName = "input.txt";
        String matchString = "like a musical instrument";
        boolean matchFound = false;

        try(Scanner scanner = new Scanner(new FileInputStream(inputFileName))) {

            while(scanner.hasNextLine()) {
                if(scanner.nextLine().contains(matchString)) {
                    matchFound = true;
                    break;
                }
            }
        } catch(IOException exception) {

            exception.printStackTrace();
        }

        if(matchFound)
            System.out.println("Match is found!");
        else
            System.out.println("Match not found!");
    }
}