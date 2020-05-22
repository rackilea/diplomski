Integer start = 0;

    query.setStart(start);
    QueryResponse response = server.query(query);
    SolrDocumentList rs = response.getResults();
    long numFound = rs.getNumFound();
    int current = 0;
    while (current < numFound) {

        ListIterator<SolrDocument> iter = rs.listIterator();
        while (iter.hasNext()) {
            current++;

            System.out.println("************************************************************** " + current + "   " + numFound);
            SolrDocument doc = iter.next();
            Map<String, Collection<Object>> values = doc.getFieldValuesMap();

            Iterator<String> names = doc.getFieldNames().iterator();
            while (names.hasNext()) {
                String name = names.next();
                System.out.print(name);
                System.out.print(" = ");

                Collection<Object> vals = values.get(name);
                Iterator<Object> valsIter = vals.iterator();
                while (valsIter.hasNext()) {
                    Object obj = valsIter.next();
                    System.out.println(obj.toString());
                }
            }
        }
        query.setStart(current);
        response = server.query(query);
        rs = response.getResults();
         numFound = rs.getNumFound();


    }
}