private int progress;

private SeekBar sb1, sb2, sb3; // And the others...

private synchronized void handleSeekBars() {
    progress = sb1.getProgress() + sb2.getProgress() + sb3.getProgress();
}