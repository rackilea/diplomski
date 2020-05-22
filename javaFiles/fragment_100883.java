package com.company;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("/home/dac/gs-rest-service/javacode/src/main/java/com/company/config.properties");
            prop.load(input);
            String extension = prop.getProperty("fileExt");
            System.out.println("ReadFiles ----Property =  " + extension);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}