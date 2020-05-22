package net.bounceme.dur.skype;

import java.io.*;

public class SkypeEchoTest {

    public static void main(String args[]) throws IOException {
        String s = null;
        Process p = Runtime.getRuntime().exec("skype --callto echo123");
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        System.out.println("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        System.exit(0);
    }
}