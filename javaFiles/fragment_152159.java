package com.example;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public final class Functions {
     private Functions() {}

     public static String prettyURL(String string) {
         return Normalizer.normalize(string.toLowerCase(), Form.NFD)
             .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
             .replaceAll("[^\\p{Alnum}]+", "-");
     }
}