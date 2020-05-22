package pakedz;
import javax.sound.midi.*;

public class odtwarzaczMuzyki {
  public void graj(){
    try {
      Sequencer sekwenser = MidiSystem.getSequencer();
      System.out.println("Mamy sekwenser");
      sekwenser.open();

      Sequence sekwencja = new Sequence(Sequence.PPQ,4);
      Track sciezka = sekwencja.createTrack();

      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, 20, 100);
      MidiEvent nutaP = new MidiEvent(a, 1);
      sciezka.add(nutaP);
      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, 44, 100);
      MidiEvent nutaK = new MidiEvent(b, 16);
      sciezka.add(nutaK);

      sekwenser.setSequence(sekwencja);
      sekwenser.start();

    }
    catch (Exception ex) { 
      System.out.println("KUTASMARIAN");
    }
  };

  public static void main (String[] args) {
    odtwarzaczMuzyki radio = new odtwarzaczMuzyki();
    radio.graj();
  }
}