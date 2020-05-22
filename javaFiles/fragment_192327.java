if (SwingUtilities.isRightMouseButton(e)) {
    mineFlagger(finalA, finalB);
}

public void mineFlagger(int x, int y) {
    if(buttons[x][y].getText().equals("F")) {
        buttons[x][y].setText("▒");
    } else if (buttons[x][y].getText().equals("▒")){
        buttons[x][y].setText("F");
    }
}