public static void convert(String fin) throws FileNotFoundException, IOException {

    ArrayList<BufferedImage> bimgArrL = getBufImgArr(fin);
    BufferedImage[] bim = new BufferedImage[bimgArrL.size()];
    bimgArrL.toArray(bim);

    try (RandomAccessOutputStream rout = new FileCacheRandomAccessOutputStream(
        new FileOutputStream("/path/you/want/result/to/go.tiff"))) {

        // The options for the tiff file are set here. 
        // **THIS BLOCK USES THE ICAFE LIBRARY TO CONVERT TO MULTIPAGE-TIFF**
        // ICAFE: https://github.com/dragon66/icafe
        ImageParam.ImageParamBuilder builder = ImageParam.getBuilder();
        TIFFOptions tiffOptions = new TIFFOptions();
        tiffOptions.setApplyPredictor(true);
        tiffOptions.setTiffCompression(Compression.CCITTFAX4);
        tiffOptions.setDeflateCompressionLevel(0);
        builder.imageOptions(tiffOptions);
        TIFFTweaker.writeMultipageTIFF(rout, bim);
        // I found this block of code here: https://github.com/dragon66/icafe/wiki
        // About 3/4 of the way down the page

    }
}