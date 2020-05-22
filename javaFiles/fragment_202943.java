private void copyFile(File from, File to) throws IOException,
        FileNotFoundException {

    FileChannel sc = null;
    FileChannel dc = null;

    try {
        to.createNewFile();

        sc = new FileInputStream(from).getChannel(); 
        dc = new FileOutputStream(to).getChannel();

        long pos = 0;
        long total = sc.size();
        while (pos < total)
            pos += dc.transferFrom(sc, pos, total - pos);

    } finally {
        if (sc != null)
            sc.close();
        if (dc != null)
            dc.close();
    }
}