TopDocs hits = searcher.search(query, searchFilter, max);
ScoreDoc[] scoreDocs = hits.scoreDocs;
for (ScoreDoc scoreDoc : scoreDocs) {
  String explanation = searcher.explain(query, scoreDoc.doc).toString();
  Log.debug(explanation);
}