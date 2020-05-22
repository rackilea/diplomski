package com.ggl.jlisttest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class JListModel {

    private static final String fileName = "words.txt";

    private List<String> wordList;

    public JListModel() {
        this.wordList = new ArrayList<String>();
        readWords();
    }

    private void readWords() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getClass()
                    .getResourceAsStream(fileName)));

            String line = "";
            while ((line = br.readLine()) != null) {
                String[] parts = getWordList(line);
                for (int i = 0; i < parts.length; i++) {
                    wordList.add(parts[i]);
                }
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

    private String[] getWordList(String line) {
        String[] parts = line.split(",");

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].substring(1);
            parts[i] = parts[i].substring(0, parts[i].length() - 1);
        }

        return parts;
    }

    public DefaultListModel<String> getListModel(String prefix) {
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (String s : wordList) {
            if (s.startsWith(prefix)) {
                listModel.addElement(s);
            }
        }

        return listModel;
    }

}