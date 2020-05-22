package org.jproggy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sorter {

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(
        new InputStreamReader(new FileInputStream(args[0])));
    String line;
    List<String> lines = new LinkedList<>();
    while ((line = in.readLine()) != null) {
      lines.add(line);
    }
    in.close();

    Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);

    for (String val: lines) {
      System.out.println(val);
    }
  }
}