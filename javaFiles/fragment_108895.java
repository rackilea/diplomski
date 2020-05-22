package com.stackoverflow.q20389463;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExForNumbersAndSpaces {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("dummy text"); // Put some dummy text
        String line = System.getProperty("line.separator"); // In windows it is \n
        builder.append(line);
        builder.append("2756 4 3179");
        builder.append(line);
        builder.append("3076 4 3179");
        builder.append(line);
        builder.append("another one");
        builder.append(line);
        builder.append("3142 4 3179");
        builder.append(line);
        builder.append("3179 4 3179");
        builder.append(line);
        builder.append("and another one");

        System.out.println("SOURCE --BEGIN--"
                + line + builder
                + line + "SOURCE --END--");
        Pattern pattern = Pattern.compile("[^\\d\\s]+[^\\n]", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(builder.toString());
        System.out.println(line + "OUTPUT --BEGIN--");
        while (matcher.find()) {
            System.out.print(matcher.group());
        }
        System.out.println(line + "OUTPUT --END--");
    }
}