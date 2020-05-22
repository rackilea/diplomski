public List<List<String>> getReportQuery(String query) {

        Session sess = getSessionFactory().getCurrentSession();
        final List<List<String>> table = new ArrayList<List<String>>();
        sess.beginTransaction();

        SQLQuery it = sess.createSQLQuery(query);
        it.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String,Object>> result = it.list();

        for(Map<String,Object> k : result){
            final List<String> tmp = new ArrayList<String>();

            for(Entry<String,Object> entry : k.entrySet())
                tmp.add(entry.getValue() != null ? entry.getValue().toString() : null);

            table.add(tmp);
        }
}