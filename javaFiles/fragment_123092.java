ShortMessage b = new ShortMessage(); 
b.setMessage(144, 0, 60, 127);
MidiEvent noteOn = new MidiEvent(b, 2);
track.add(noteOn);

// Here's your note_off
ShortMessage b1 = new ShortMessage(); 
b1.setMessage(128, 1, 44, 100);
MidiEvent noteOff = new MidiEvent(b1, 16);
track.add(noteOff);