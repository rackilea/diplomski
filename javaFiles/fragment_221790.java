package com.company;

class Answer {

    private final String letter;
    private final String value;

    Answer(String letter, String value) {
        this.letter = letter;
        this.value = value;
    }

    String getLetter() {
        return letter;
    }

    String getValue() {
        return value;
    }
}