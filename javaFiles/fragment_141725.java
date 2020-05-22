public class CustomReceiver implements Receiver {

    public CustomReceiver() {

    }
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage) {
            ShortMessage sm = (ShortMessage) message;
            System.out.print("Channel: " + sm.getChannel() + " ");
            if (sm.getCommand() == NOTE_ON) {
                int key = sm.getData1();
                int octave = (key / 12)-1;
                int note = key % 12;
                String noteName = NOTE_NAMES[note];
                int velocity = sm.getData2();
                System.out.println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity);
            } else if (sm.getCommand() == NOTE_OFF) {
                int key = sm.getData1();
                int octave = (key / 12)-1;
                int note = key % 12;
                String noteName = NOTE_NAMES[note];
                int velocity = sm.getData2();
                System.out.println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity);
            } else {
                System.out.println("Command:" + sm.getCommand());
            }
        } else {
            System.out.println("Other message: " + message.getClass());
        }
    }

    @Override
    public void close() {

    }
}