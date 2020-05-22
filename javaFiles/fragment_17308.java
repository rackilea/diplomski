for (ScoreDoc sd : topDocs.scoreDocs) {
  if (sd.doc == Integer.MAX_VALUE) break;
  final Document d = searcher.doc(sd.doc);
  final Fieldable f = d.getFieldable(name);
  ...
}