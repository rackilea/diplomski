/**
 * copy file from source to destination
 *
 * @param src source
 * @param dst destination
 * @throws java.io.IOException in case of any problems
 */
void copyFile(File src, File dst) throws IOException {
    FileChannel inChannel = new FileInputStream(src).getChannel();
    FileChannel outChannel = new FileOutputStream(dst).getChannel();
    try {
        inChannel.transferTo(0, inChannel.size(), outChannel);
    } finally {
        if (inChannel != null)
            inChannel.close();
        if (outChannel != null)
            outChannel.close();
    }
}