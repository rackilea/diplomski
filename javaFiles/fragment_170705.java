package com.raj.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShellComand {

    public static void main(String[] args) {

        ExecuteShellComand obj = new ExecuteShellComand();

        String output = obj.executeCommand();

        System.out.println(output);

    }

    private String executeCommand() {

        StringBuffer output = new StringBuffer();

        try {

            Process p = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", "cd && cat test.txt | grep Hello"});
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

}