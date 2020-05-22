private void createSineWaveBuffer(final double freq, final byte[] buffer) {

    for(int i = 0; i < buffer.length; ++i) {
        buffer[i] = (byte)(Math.sin(alpha)*127.0);
        alpha += freq*step_alpha;

        if(alpha >= 2.0*Math.PI) {
            alpha -= 2.0*Math.PI;
        }
    }

    return t;
}