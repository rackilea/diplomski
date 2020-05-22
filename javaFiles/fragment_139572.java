interface Slide<N extends Notes<?>> {
    N getNotes();
    void setNotes(N n);
}

class HSLFSlide implements Slide<HSLFNotes> {
    HSLFNotes notes = new HSLFNotes();

    @Override
    public HSLFNotes getNotes() { return notes; }
    @Override
    public void setNotes(HSLFNotes n) { notes = n; }
}