public class MidiReadAndPlay {

    public static Receiver synthRcvr = new CustomReceiver();
    public static Transmitter seqTrans;
    public static Synthesizer synth;
    public static Sequencer sequencer;
    public static Sequence sequence;

    public static void main(String[] args) throws Exception {      
        sequencer = MidiSystem.getSequencer();
        sequence = MidiSystem.getSequence(new File("midi.mid"));

        Sequencer sequencer = MidiSystem.getSequencer();
        seqTrans = sequencer.getTransmitter();
        seqTrans.setReceiver(synthRcvr);

        sequencer.open(); 
        sequencer.setSequence(sequence);

        sequencer.start();
    }

}