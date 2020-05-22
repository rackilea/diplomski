BandPass bandpass = new BandPass(19000,2000,44100);
while ((count = dataInputStream.read(data, 0, bufferSize)) > -1) {
  // decode and deinterleave stereo 16-bit per sample data
  float[][] signals = deinterleaveData(byteToFloat(data), 2);

  // filter data samples, updating the buffers with the filtered samples.
  bandpass.process(signals[0], signals[1]);

  // recombine signals for playback
  audioTrack.write(interleaveData(signals), 0, count, WRITE_NON_BLOCKING);
}