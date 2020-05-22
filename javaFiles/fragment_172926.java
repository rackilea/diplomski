public class Chord {
    private final List<Note> notes;

    ...

    public boolean contains(Note note) {
        return notes.contains(note);
    }
}