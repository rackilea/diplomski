package com.nikhil.string;

import java.io.IOException;

import java.util.Scanner;

public class demo1 {

public static void main(String[] args) throws IOException {

    String[] s;
    String sentence, word;

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the sentence");

    sentence = sc.nextLine();

    System.out.println("Enter the word to be deleted");
    word = sc.nextLine();

    String finalSentence = "";

    s = sentence.split(" ");

    for (int i = 0; i < s.length; i++) {
        if (word.equals(s[i])) {
            continue;
        } else {
            finalSentence += s[i] + " ";
        }

    }

    System.out.println("final sentence is :: " + finalSentence);
    sc.close();

}