try {

   ........
} finally {
    IOUtils.closeQuietly(bfw);
    IOUtils.closeQuietly(pw);
}