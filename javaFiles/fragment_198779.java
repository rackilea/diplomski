// Param for playback (input) device.
Line.Info playbackLine = new Line.Info(SourceDataLine.class);
// Param for capture (output) device.
Line.Info captureLine = new Line.Info(TargetDataLine.class);


private List<Mixer.Info> filterDevices(final Line.Info supportedLine) {
    List<Mixer.Info> result = Lists.newArrayList();

    ArrayList<Mixer.Info> infos = Lists.newArrayList(AudioSystem.getMixerInfo());
    for (Mixer.Info info : infos) {
        Mixer mixer = AudioSystem.getMixer(info);
        if (mixer.isLineSupported(supportedLine)) {
            result.add(info);
        }
    }
    return result;
}