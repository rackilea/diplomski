public static boolean gzipToFile(CharSequence from, File to, Charset charset) {
    try (FileOutputStream fos = new FileOutputStream(to);
         BufferedOutputStream bos = new BufferedOutputStream(fos);
         GZIPOutputStream gzos = new GZIPOutputStream(bos);
         OutputStreamWriter w = new OutputStreamWriter(gzos, charset)) {
        w.append(from);
        w.close();
        return true;
    } catch (final IOException e) {
        // ignore
    }
    return false;
}