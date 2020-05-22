package com.foundations.framework.concurrency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class FileSummarizer {

  public static void main(String[] args) {
    HashMap<String, Long> rows = new HashMap<String, Long>();
    String line = "";
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader("data.txt"));
      while ((line = reader.readLine()) != null) {
        String[] tokens = line.split(" ");
        String key = tokens[0].toLowerCase();
        Long current = Long.parseLong(tokens[1]);

        Long previous = rows.get(key);
        if(previous != null){
          current += previous;
        }
        rows.put(key, current);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        reader.close();
        Iterator<String> iterator = rows.keySet().iterator();
        while (iterator.hasNext()) {
          String key = iterator.next().toString();
          String value = rows.get(key).toString();

          System.out.println(key + " " + value);
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}