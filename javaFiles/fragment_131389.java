class Ideone
{
    private static native void bytesToDoubles(byte[] src, int srcpos,
                                          double[] dst, int dstpos,
                                          int ndoubles);
    public static void main (String[] args) throws java.lang.Exception
    {
        byte[] bytes = { 1, 2, 3 ,4, 5, 6, 7, 8};
        double[] dst = new double[1];
        bytesToDoubles(bytes, 0, dst, 0, 1);
        System.out.println(dst[0]);
    }
}