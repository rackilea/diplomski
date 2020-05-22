package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {
        System.out.println("in here");
        String text = "https://www.w3.org/TR/owl-features/";
        // wont' match https://www.w3.org/TR/owl-features
        // but will match https://www.w3.org/TR/owl-features/
        Pattern regx = Pattern.compile("(https?|ftp|file)://.*\\/$");
        Matcher linkswslash = regx.matcher(text);
        if (linkswslash.find()){
            System.out.println("Found value: " + linkswslash.group());
        } else {
            System.out.println("Not found");
        }
    }
}