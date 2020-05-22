private int x;
private boolean x_was_touched = false;

public void setX (int newXvalue) {
    if (!x_was_touched) {
       x = newXvalue;
       x_was_touched = true;
    }
}

public int getX() {
    return x;
}