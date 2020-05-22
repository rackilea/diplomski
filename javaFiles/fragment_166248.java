public void storeImage(TiledImage img, String filepath) {
    TIFFEncodeParam tep = new TIFFEncodeParam();
    //important to avoid OutOfMemory
    tep.setTileSize(256, 256);
    tep.setWriteTiled(true);
    //fast compression
    tep.setCompression(TIFFEncodeParam.COMPRESSION_PACKBITS);
    //write file
    JAI.create("filestore", img, filepath, "TIFF", tep);
}