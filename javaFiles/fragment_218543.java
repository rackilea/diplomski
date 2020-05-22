public static String[] concatArrays(String[] src1, String[] src2) {
    if (src1 == null) {
        throw new IllegalArgumentException("src1 is required.")
    }        
    if (src2 == null) {
        throw new IllegalArgumentException("src2 is required.")
    }        

    String[] result = new String[src1.length + src2.length];

    System.arraycopy(src1, 0, result, 0, src1.length);
    System.arraycopy(src2, 0, result, src1.length, src2.length);

    return result;
}