OutputStream os = . . .;
OutputStream gzos = new GZIPOutputStream(os) {
    {
        // def is an inherited, protected field that does the actual compression
        def = new Deflator(9, true); // maximum compression, no ZLIB header
    }
};