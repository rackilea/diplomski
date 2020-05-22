File file = ...;
WavFile wav = new WavFile(file);

int amplitudeExample = wav.getSampleInt(140); // 140th amplitude value.

for (int i = 0; i < wav.getFramesCount(); i++) {
    int amplitude = wav.getSampleInt(i);
    // Plot.
}