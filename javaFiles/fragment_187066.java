package com.example;

import java.io.IOException;
import java.lang.Runtime;

public class Main {
    public static void main (String args[]) {
        try {
            if (args.length < 1) {
                System.out.println("Start server");
                Runtime.getRuntime().exec(new String[]{ "cmd", "/c", "start /wait \"launcher_cmd\" s.bat"});
            } else {
                System.out.println("Stop server");
                Runtime.getRuntime().exec(new String[]{ "cmd", "/c", "taskkill /fi \"WINDOWTITLE eq launcher_cmd*\" /t /f"});
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}