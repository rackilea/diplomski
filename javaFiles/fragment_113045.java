package com.ggl.testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertBytes implements Runnable {

    private String fileName;

    public static void main(String[] args) {
        new ConvertBytes("bytes.txt").run();
    }

    public ConvertBytes(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(getClass()
                    .getResourceAsStream(fileName)));
            String line = "";
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processLine(String line) {
        String[] parts = line.split("(?=\\\\)");
        List<Byte> byteList = new ArrayList<Byte>();

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("")) {
                continue;
            } else {
                byteList.addAll(getValue(parts[i]));
            }
        }

        Byte[] bytes = byteList.toArray(new Byte[byteList.size()]);
        System.out.println(Arrays.toString(bytes));
    }

    private List<Byte> getValue(String s) {
        List<Byte> byteList = new ArrayList<Byte>();

        if (s.startsWith("\\x")) {
            int value = Integer.valueOf(s.substring(2, 4), 16);
            if (value > 127) {
                value = value - 256;
            }
            byteList.add(Byte.valueOf((byte) value));
            if (s.length() > 4) {
                byteList.addAll(getAsciiValue(s.substring(4)));
            }
        } else if (s.equals("\\r")) {
            byteList.add(Byte.valueOf((byte) 13));
        } else if (s.equals("\\t")) {
            byteList.add(Byte.valueOf((byte) 9));
        } else {
            byteList.addAll(getAsciiValue(s));
        }

        return byteList;
    }

    private List<Byte> getAsciiValue(String s) {
        List<Byte> byteList = new ArrayList<Byte>();

        for (int i = 0; i < s.length(); i++) {
            int value = (int) s.charAt(i);
            byteList.add(Byte.valueOf((byte) value));
        }

        return byteList;
    }

}