package com.stackoverflow.answer;

public class RegexTest {

    public static void main(String[] args) {
        String input = "It might be more sensible for real users if I also included a lower limit on the number of letters.";
        System.out.println("BEFORE: " + input);
        input = input.replaceAll("\\b[\\w']{1,2}\\b", "").replaceAll("\\s{2,}", " ");
        System.out.println("AFTER: " + input);
    }

}