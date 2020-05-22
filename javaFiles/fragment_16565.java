...
DirectoryReader reader = DirectoryReader.open(MMapDirectory.open( java.io.File(indexFile) );
IndexSearcher searcher = new IndexSearcher(reader);
TopScoreDocCollector collector = TopScoreDocCollector.create(MAX_RESULTS, true);  // MAX_RESULTS is just an int limiting the total number of hits 
int startIndex = (page -1) * hitsPerPage;  // our page is 1 based - so we need to convert to zero based
Query query = new QueryParser(Version.LUCENE_48, "All", analyzer).parse(searchQuery);
searcher.search(query, collector);
TopDocs hits = collector.topDocs(startIndex, hitsPerPage);
...