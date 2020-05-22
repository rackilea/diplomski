if (in.markSupported()) {
    final int maxBytesNeededForDetection = 8192;
    in.mark(maxBytesNeededForDetection);
    ... do the detection
    in.reset();
} else {
    throw IllegalState();
}