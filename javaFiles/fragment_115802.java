package org.mihai.script;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String entry = "test entry 2";
        System.out.println("adding: " + entry);

        Process pr = null;
        try {
            pr =
 Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", "cd /home/oracle/testscript ; . ./test.sh " + "\"" + entry +"\"" });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}