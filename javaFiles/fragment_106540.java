package com.unthreading.mavenchinesechars;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ChineseChars {

public static void main(String[] args) throws UnsupportedEncodingException {

    System.out.println("System.getProperty(\"file.encoding\"): " + System.getProperty("file.encoding"));
    System.out.println("Charset.defaultCharset(): " + Charset.defaultCharset());
    System.out.println("System.getProperty(\"java.version\"): " + System.getProperty("java.version"));

    String text = "你好！"; 
    System.out.println(text); // <<<======================= Fails!       
    System.setOut(new PrintStream(System.out, true, "UTF8")); // Essential!
    System.out.println(text); // <<<======================= Works!       
}
}