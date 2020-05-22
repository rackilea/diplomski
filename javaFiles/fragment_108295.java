WoffWriter ww = new WoffWriter();
    WriteableFontData wfd = ww.convert(yourFont);
    try {
        FileOutPutStream fs = new FileOutputStream("out.fnt");
        wfd.copyTo(fs, wfd);
        fs.close();
    } catch (IOException e) {
    }