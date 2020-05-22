try (Sequencer sequencer = MidiSystem.getSequencer()) {
    sequencer.open();
    Sequence sequence = new Sequence(Sequence.PPQ, 1);
    Track track = sequence.createTrack();

    ShortMessage noteOnMsg = new ShortMessage();
    noteOnMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 100);
    ShortMessage noteOffMsg = new ShortMessage();
    noteOffMsg.setMessage(ShortMessage.NOTE_OFF, 0, 60, 100);

    track.add(new MidiEvent(noteOnMsg, 0));
    track.add(new MidiEvent(noteOffMsg, 120));
    sequencer.setSequence(sequence);

    sequencer.start();
    Thread.sleep(5000);
    sequencer.stop();
}