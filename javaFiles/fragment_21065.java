package com.mysuper.sdk;

// Package protected class.
class Controller {
    // Private model.
    private Model model = new Model();

    // Package protected method.
    String translateNumbers(int... numbers) {
        String translation = "";
        for (int number : numbers) {
            translation = translation + model.get(number) + " ";
        }
        return translation;
    }
}