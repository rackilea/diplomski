public static void reencode(String orig, String dest) {
    PngReader png1 = FileHelper.createPngReader(new File(orig));
    ImageInfo pnginfo1 = png1.imgInfo;
    ImageInfo pnginfo2 = new ImageInfo(pnginfo1.cols, pnginfo1.rows, 4, false,false,true);  
    PngWriter png2 = FileHelper.createPngWriter(new File(dest), pnginfo2, false);
    png2.copyChunksFirst(png1, ChunksToWrite.COPY_ALL);
    ImageLine l2 = new ImageLine(pnginfo2);
    for (int row = 0; row < pnginfo1.rows; row++) {
        ImageLine l1 = png1.readRow(row);
        l2.tf_pack(l1.scanline, false);
        l2.setRown(row);
        png2.writeRow(l2);
    }
    png1.end();
    png2.copyChunksLast(png1, ChunksToWrite.COPY_ALL);
    png2.end();
    System.out.println("Done");
}