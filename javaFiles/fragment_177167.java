private void SearchDocumentsTypeII(SolrDocumentList results,
            SolrIndexSearcher searcher, String q, 
            UserPermissions up, int ndocs, SolrQueryRequest req,
            Map<String, SchemaField> fields, Set<Integer> alreadyFound)
            throws IOException, ParseException {


             BooleanQuery bq = new BooleanQuery();
             String permLvl = "PermissionLevel:" + up.getPermissionLevel();
             QParser parser = QParser.getParser(permLvl, null, req);
             bq.add(parser.getQuery(), Occur.MUST);

             Filter filter = CachingWrapperFilter(new QueryWrapperFilter(bq));   

             QueryParser qp = new QueryParser(q, new StandardAnalyzer());
             Query query =  qp.parse(q);                        

             append (results, searcher.search(
              query, filter, 50).scoreDocs,
              alreadyFound, fields, new HashMap<String,Object>(), 0,
              searcher.getReader(), true);
        }