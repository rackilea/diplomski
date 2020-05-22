package com.me;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String [] args) {
        Map<String, CommandRunner> verMap = new HashMap<String, CommandRunner>();

        // Add all the commands :
        verMap.put("clear", new CommandRunner() {
            @Override
            public String run() {
                try {
                    Runtime.getRuntime().exec("cls");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                return "";
            }
        });

        // Run it
        verMap.get("clear").run();
    }
}