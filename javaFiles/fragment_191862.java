File a = new File("data/readme.txt.gz");
File o = new File("data/");
Compressor compressor = CompressorFactory.createCompressor(a);
try {
    compressor.decompress(a, o);
} catch (IOException ex) {
    ex.printStackTrace();
}