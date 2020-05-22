public static void close(Closeable stream) {
    try {
        if (stream != null) {
            stream.close();
        }
    } catch(IOException e) {
        //...
    }
}