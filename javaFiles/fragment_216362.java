package com.ggl.text.game;

public class NorthAction implements WordAction {

    private static final String WORD = "north";

    @Override
    public boolean isWord(String word) {
        word = word.toLowerCase();
        if (WORD.equals(word) || (WORD.startsWith(word))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void execute() {
        // TODO Move player North
    }

}