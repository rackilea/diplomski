public class Notes {
  public static void main(String [] args) {
    String notes = "C C#D D#E F F#G G#A A#B ";
    int octv;
    String nt;
    for (int noteNum = 0; noteNum < 128; noteNum++) {
      octv = noteNum / 12 - 1;
      nt = notes.substring((noteNum % 12) * 2, (noteNum % 12) * 2 + 2);
      System.out.println("Note # " + noteNum + " = octave " + octv + ", note " + nt);
    }
  }
}