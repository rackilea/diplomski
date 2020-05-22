package net.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[]args) {
        BufferedReader br = null;

        try {
            InputStream is = Test.class.getResourceAsStream("/assets/Test.txt");

            if(is != null) {
                br = new BufferedReader(new InputStreamReader(is)); 

                //Print the content of Test.txt
                String line;
                while((line = br.readLine()) != null) {
                    System.out.println(line); 
                }
            } else {
                //Resource not found
                System.out.println("Resource unavailable!");
            }

        } catch (IOException e) {
            e.printStackTrace(); //Log IO Error
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {}
            }
        }
    }
}