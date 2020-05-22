private int index(File indexDir, File dataDir, String suffix) throws Exception {
    RAMDirectory ramDir = new RAMDirectory();
    IndexWriter indexWriter = new IndexWriter(ramDir,
        new StandardAnalyzer(Version.LUCENE_CURRENT), true,  
        IndexWriter.MaxFieldLength.UNLIMITED);
    indexWriter.setUseCompoundFile(false);
    indexDirectory(indexWriter, dataDir, suffix);
    int numIndexed = indexWriter.maxDoc();
    indexWriter.optimize();
    indexWriter.close();


    IndexWriter index = new IndexWriter(FSDirectory.open(indexDir),
        new StandardAnalyzer(Version.LUCENE_CURRENT), true,  
        IndexWriter.MaxFieldLength.UNLIMITED);
    index.addIndexesNoOptimize(ramDir);
    index.optimize();
    index.close();

    return numIndexed;
}