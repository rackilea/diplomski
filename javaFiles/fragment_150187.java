InputStream in = // stream from server
    in = new BufferedInputStream(in);
    in.mark(1024);

    try {
        in = new GZIPInputStream(in);
    }
    catch (ZipException ex) {
        in.reset();
    }

    // "in" is now ready for use