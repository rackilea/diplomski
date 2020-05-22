public void initialize(File newIndexDirectory) throws CorruptIndexException, IOException {
        try {
            File path = (newIndexDirectory == null) ? new File(indexDirectory) : newIndexDirectory;
            Directory index = new SimpleFSDirectory(path);
            searcher = new IndexSearcher(index);
            logger.debug("Successfully initialized index at: " + path.getAbsolutePath());
            currentIndexFile = path;
        } catch (Exception e) {
            logger.warn("Lucene index is corrupt");
        }
    }