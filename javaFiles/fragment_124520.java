public class WDUtils {
    /**
     * Make a direct NIO FloatBuffer from an array of floats
     * 
     * @param arr
     *            The array
     * @return The newly created FloatBuffer
     */
    public static final FloatBuffer floatBuffer(float[] arr) {
        ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(arr);
        fb.position(0);
        return fb;
    }
}