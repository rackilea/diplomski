package com.mysuper.sdk;

// Package protected class.
class Model {
    // Private database.
    private String[] database = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    // Package protected method.
    String get(int number) {
        if (number < 0 || number > 9) {
            throw new NumberFormatException("Number " + number + " is not between 0 and 9.");
        } else {
            return database[number];
        }
    }
}