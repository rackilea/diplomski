IndexReader indexReaderUpdate = DirectoryReader.open(indexDir);

// Use indexReaderUpdate here, instead of indexReader
IndexSearcher searcherUpdate = new IndexSearcher(indexReader);

// Use searcherUpdate here, instead of searcher
TopDocs docsUpdate = searcher.search(new TermQuery(new Term("int1", "hello")), 10);