public static void addTif(Document document, String path)
    throws DocumentException, IOException {
    RandomAccessFileOrArray ra = new RandomAccessFileOrArray(path);
    int n = TiffImage.getNumberOfPages(ra);
    Image img;
    for (int i = 1; i <= n; i++) {
        img = TiffImage.getTiffImage(ra, i);
        img.scaleToFit(523, 350);
        document.add(img);
    }
}