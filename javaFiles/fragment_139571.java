interface Slide<SS extends SlideShow> {
    Notes<SS> getNotes();
    void setNotes(Notes<SS> n);
}

class HSLFSlide implements Slide<HSLFSlideShow> {
    Notes<HSLFSlideShow> notes = new HSLFNotes();

    @Override
    public Notes<HSLFSlideShow> getNotes() { return notes; }
    @Override
    public void setNotes(Notes<HSLFSlideShow> n) { notes = n; }
}