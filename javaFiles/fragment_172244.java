package com.stackoverflow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    public static final String CSVFILE = "src/com/stackoverflow/myfile.csv";

    public static void main(String[] args) {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\\t+"; // use tab as separator

        try {    
            br = new BufferedReader(new FileReader(CSVFILE));
            while ((line = br.readLine()) != null) {

                String[] info = line.split(cvsSplitBy);

                StringBuilder details = new StringBuilder();
                details.append("ID = ");
                details.append(info[0]);
                details.append(", Country = ");
                details.append(info[1]);

                System.out.println(details.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}