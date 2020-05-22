for(final File file : files) {

    final InputStream in = new BufferedInputStream(new FileInputStream(file));
    final OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(...)));
    try {
        // Process each file and save it to file
    }
    finally {
        try {
            in.close();
        }
        catch (IOException ignored) {}
        try {
            out.close();
        }
        catch (IOException ignored) {}
    }
}