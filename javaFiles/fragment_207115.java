InputStream in = null;
try {
    in = fileObject.getReadStream();
    // do whatever, possibly throwing exception
} finally {
    if (in  != null) {
        try {
           in.close();
        } catch (Exception ex) {
            // failure to close input stream is no problem if everything else was ok
        }
    }
}