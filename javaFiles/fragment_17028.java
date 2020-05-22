// In the listener
    public void mouseClicked(MouseEvent e) {
       Point p = MouseInfo.getPointerInfo().getLocation();
       addShape(g, p.x, p.y, currentNote);
       int pitch = 12;
       piano.playNote(pitch);
       advance(1.0, piano);
       try { addToFile(pitch, currentNote);}
       catch(FileNotFoundException fnfe) {}
       catch(IOException ioe) {}
    }

// In the same class
protected String currentNote;

...

public void getShape(final Graphics g, final String note) {
    currentNote = note;
}