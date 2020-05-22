package org.script.test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid arguments");
            return;
        }
        String entry="\"" +args[0]+ "\"";
        System.out.println("adding: " + entry);

        Process pr = null;
        try {
            pr =
 Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", "cd /home/oracle/testscript ; . ./test.sh " + entry });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}