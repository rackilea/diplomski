package com.ekanathk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import org.junit.Test;

class Entry {
    private String input;
    private int level;
    public Entry(String input, int level) {
        this.input = input;
        this.level = level;
    }
    public String getInput() {
        return input;
    }
    public int getLevel() {
        return level;
    }
    @Override
    public String toString() {
        return "Entry [input=" + input + ", level=" + level + "]";
    }
}

public class Tester {

    private static final Logger logger = Logger.getLogger(Tester.class.getName());

    @SuppressWarnings("unchecked")
    @Test
    public void testSomething() throws Exception {

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("samplecsv.txt");
        BufferedReader b = new BufferedReader(new InputStreamReader(is));
        String input = null;
        List entries = new ArrayList();
        Stack<Entry> stack = new Stack<Entry>();
        stack.push(new Entry("ROOT", -1));
        while((input = b.readLine()) != null){
            int level = whatIsTheLevel(input);
            input = input.trim();
            logger.info("input = " + input + " at level " + level); 
            Entry entry = new Entry(input, level);
            if(level == 1) {
                //periodically clear out the map and write it to another excel sheet
            }
            if (stack.peek().getLevel() == entry.getLevel()) {
                stack.pop();
            }
            Entry parent = stack.peek();
            logger.info("parent = " + parent);
            entries.add(new String[]{parent.getInput(), entry.getInput()});
            stack.push(entry);
        }
        for(Object entry : entries) {
            System.out.println(Arrays.toString((String[])entry));
        }
    }

    private int whatIsTheLevel(String input) {
        int numberOfSpaces = 0;
        for(int i = 0 ; i < input.length(); i++) {
            if(input.charAt(i) != ' ') {
                return numberOfSpaces/4;
            } else {
                numberOfSpaces++;
            }
        }
        return numberOfSpaces/4;
    }
}