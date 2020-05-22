QueryParser parser = new QueryParser("Body", new EnglishAnalyzer());
Query query = parser.parse(topic);
TopDocs hits = iSearcher.search(query, 1000);
for (int i=0; i<hits.scoreDocs.length; i++){
     Terms termVector = iSearcher.getIndexReader().getTermVector(hits.scoreDocs[i].doc, "Body");
     Document doc = iSearcher.doc(hits.scoreDocs[i].doc);
     documentsList.put(doc, termVector);
}