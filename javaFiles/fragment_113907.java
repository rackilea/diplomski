/** transcodes text file from one encoding to another */
public static void transcode(File source, Charset srcEncoding,
                             File target, Charset tgtEncoding)
                                                             throws IOException {
    try (InputStream in = new FileInputStream(source);
         Reader reader = new InputStreamReader(in, srcEncoding);
         OutputStream out = new FileOutputStream(target);
         Writer writer = new OutputStreamWriter(out, tgtEncoding)) {
        char[] buffer = new char[1024];
        int r;
        while ((r = reader.read(buffer)) != -1) {
            writer.write(buffer, 0, r);
        }
    }
}