public class CuttingAudioInputStream extends AudioInputStream {

    private AudioInputStream delegate;

    public CuttingAudioInputStream(AudioInputStream delegate) {
        this.delegate = delegate;
    }

    /**
     * Lie about length of delegate
     */
    public long getFrameLength() {
        // simple demo, make the caller think the stream is 44100 samples long
        return Math.min(delegate.getFrameLength(), 44100); 
    }

    // Overrides for all other methods of AudioInputStream, 
    // left as excercise to the reader
}