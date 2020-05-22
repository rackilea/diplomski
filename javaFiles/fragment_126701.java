System.out.println("Starting readLineWithFinally method.");
RandomAccessFile in = null;
try {
    in = new RandomAccessFile("products.ran", "r");
    String s = in.readLine();
    return s;
} catch (IOException e) {
    System.out.println(e.toString());
    return null;
} finally {
    try {
        if(in != null) {
            in.close();
        }
    } catch (Exception e) {
        System.out.println("Generic Error Message");
    }
}