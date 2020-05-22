public void setHole(int hole, String text) {
    if (hole >= 0 && hole < holes.length) {
        holes[hole].setText(text);
    }
}

public String getHole() {
    String text = null;
    if (hole >= 0 && hole < holes.length) {
        text = holes[hole].getText();
    }
    return text;
}