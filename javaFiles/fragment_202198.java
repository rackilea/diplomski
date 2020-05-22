public class FixedSecureRandom extends SecureRandom {
    private static boolean debug = false;
    private static final long serialVersionUID = 1L;
    public FixedSecureRandom() { }
    private int nextBytesIndex = 0;

    private byte[] nextBytesValues = null;

    public void setBytes(byte[] values) {
        this.nextBytesValues = values; 
    }

    public void nextBytes(byte[] b) {
        if (nextBytesValues==null) { 
            super.nextBytes(b);
        } else if (nextBytesValues.length==0) { 
            super.nextBytes(b);
        } else {
            for (int i=0; i<b.length; i++) {
                b[i] = nextBytesValues[nextBytesIndex];
                nextBytesIndex = (nextBytesIndex + 1) % nextBytesValues.length;
            }
        }
    }
}