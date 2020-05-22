IRandomAccessSource ras3 =
    new RandomAccessSourceFactory().createSource(url3);
RandomAccessFileOrArray raf3 = new RandomAccessFileOrArray(ras3);
int pages3 = TiffImageData.getNumberOfPages(raf3);
for (int i = 1; i <= pages3; i++) {
    img = new Image(
        ImageDataFactory.createTiff(url3, true, i, true));
    document.add(img);
}
document.close();