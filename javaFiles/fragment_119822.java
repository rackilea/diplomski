String mySQLString = "SELECT ID FROM Document WHERE DocumentTitle LIKE '"+prp+"'";
    SearchSQL sqlObject = new SearchSQL();
    sqlObject.setQueryString(mySQLString);

    SearchScope searchScope = new SearchScope(os);
    RepositoryRowSet rowSet = searchScope.fetchRows(sqlObject, null, null, new Boolean(true));
    Iterator ppg = rowSet.iterator();

    if (ppg.hasNext()) {

            RepositoryRow rr = (RepositoryRow) ppg.next();
            System.err.println(rr.getProperties());
            Properties properties = rr.getProperties();

            String ID = properties.getIdValue("ID").toString();
            System.out.println(ID);                

            doc  =  Factory.Document.fetchInstance(os,ID,null);

    }