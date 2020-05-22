File file = null;
    try {
        file = File.createTempFile("XYZ", "Directory");
        file.delete();
        file.mkdirs();
        System.out.println(file);
    } catch (final IOException e) {
        e.printStackTrace();
    }
    return file;