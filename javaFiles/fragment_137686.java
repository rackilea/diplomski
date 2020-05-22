private int index(File indexDir, File dataDir, String suffix) throws Exception {

    IndexWriter index = new IndexWriter(FSDirectory.open(indexDir),
        new StandardAnalyzer(Version.LUCENE_CURRENT), true,  
        IndexWriter.MaxFieldLength.UNLIMITED);

    // tweak the settings for your hardware
    index.setUseCompoundFile(false);
    index.setRAMBufferSizeMB(256);
    index.setMergeFactor(30);

    indexDirectory(index, dataDir, suffix);

    index.optimize();
    int numIndexed = index.maxDoc();
    index.close();

    // you'll need to update indexDirectory() to keep track of indexed files
    return numIndexed;
}