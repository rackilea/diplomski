AudioFormat format = new AudioFormat(44000f, 16, 1, true, false);
SourceDataLine line = (SourceDataLine)AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, format));

line.open(format);
line.start();

double f = 440; // Hz
double t = 3; // seconds

byte[] buffer = new byte[(int)(format.getSampleRate() * t * 2 + .5)];

f *= Math.PI / format.getSampleRate();

for(int i = 0; i < buffer.length; i += 2) {
    int value = (int)(32767 * Math.sin(i * f));
    buffer[i + 1] = (byte)((value >> 8) & 0xFF);
    buffer[i] = (byte)(value & 0xFF);
}

line.write(buffer, 0, buffer.length);

line.drain();