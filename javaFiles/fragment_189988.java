try {
    InputStream input = new BufferedInputStream(new FileInputStream(file));
    try {
        // ...
        input.read(buffer);
        // ...
    }
    finally {
        input.close();
    }
}
catch (IOException e) {
    e.printStackTrace();
}