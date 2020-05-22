public static void playChord(double[] frequencies)
    throws LineUnavailableException 
{
    double[] buffer = tone(frequencies[0], 1.0, 1, 0);

    for(int i = 1; i < frequencies.length; ++i) {
        double[] harmonic = tone(frequencies[i], 1.0, 1, 0);

        for(int i = 0; i < buffer.length; ++i) {
            buffer[i] += harmonic[i];
        }
    }

    for(int i = 0; i < buffer.length; ++i) {
        buffer[i] /= frequencies.length;
    }

    Audio.play(buffer);
}