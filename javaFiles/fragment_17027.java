private MouseListener wholeNote = new MouseListener()...;
private MouseListener quarterNote = new MouseListener()...;
private MouseListener current;

...

public void getShape(final Graphics g, final String note) {
    if (current != null) {
        this.removeMouseListener(current);
    }

    if (...) { // note is Whole Note
        current = wholeNote;
    } else if (...) { // note is Quarter Note
        current = quarterNote;
    } // etc.

    this.addMouseListener(current);
}