private double[][] song;

public Guitar(int mstrings, int mchords) {
    this.strings = mstrings;
    this.chords = mchords;

    song = new double[mstrings][mchords];
}