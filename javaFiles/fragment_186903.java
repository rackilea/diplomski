package com.ggl.testing;

import java.util.ArrayList;
import java.util.List;

public class DoubleWord implements Runnable {

    public static void main(String[] args) {
        new DoubleWord().run();
    }

    @Override
    public void run() {
        Dictionary dictionary = new Dictionary();
        System.out.println(splitWord("missspelling", dictionary));
        System.out.println(splitWord("apple", dictionary));
    }

    public String splitWord(String word, Dictionary dictionary) {
        for (int index = 1; index < word.length(); index++) {
            String prefix = word.substring(0, index);
            if (dictionary.isWordInDictionary(prefix)) {
                String suffix = word.substring(index);
                if (dictionary.isWordInDictionary(suffix)) {
                    return prefix + " " + suffix;
                }
            }
        }

        return word;
    }

    public class Dictionary {
        private List<String> words;

        public Dictionary() {
            this.words = setWords();
        }

        public boolean isWordInDictionary(String word) {
            return words.contains(word);
        }

        private List<String> setWords() {
            List<String> words = new ArrayList<>();
            words.add("apple");
            words.add("miss");
            words.add("spelling");
            words.add("zebra");

            return words;
        }
    }

}