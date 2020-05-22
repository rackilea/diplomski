package com.foo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

 public static void main(String[] args) {
    Pattern compile = Pattern.compile("at\\s(\\d{1,5}[\\s\\w,\\d]+)\\.",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE| Pattern.UNICODE_CHARACTER_CLASS);
    String s ="23 July 2016\n"
            + "George Washington living at 5664 rue pierre labelle montreal QC G1H 3A4. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n"
            +"05 January 2016\n"
            + "Juana Perez living at 5456 avenue martin curé, sherbrooke, QC, G1H 3A8. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    System.out.println(s);
    System.out.println(System.getProperty("line.separator"));
    System.out.println("Searching Addresses.....");
    System.out.println(System.getProperty("line.separator"));
    Matcher matcher = compile.matcher(s);
    while(matcher.find()){
        System.out.println(matcher.group(1));
    }
    System.out.println(System.getProperty("line.separator"));
    System.out.println("Completed Searching Addresses");


 }
}