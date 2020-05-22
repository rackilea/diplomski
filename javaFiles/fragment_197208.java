public void upsertAttributes(final String userId, final Map<String, String> attributes) {

    try {
        String[] keys = (String[])attributes.keySet().toArray();

        String sql = "INSERT INTO PROFILE(userId, "+keys[0]+", "+keys[1]+", "+keys[2]+", "+keys[3]+") VALUES ( ?, ?, ?, ?, ?) "; 
        StringBuffer keysStmt = new StringBuffer("INSERT INTO PROFILE("+userId);
        StringBuffer valuesStmt = new StringBuffer("  VALUES (" );

        Iterator itr = attributes.keySet().iterator();

        while(itr.hasNext()){
            String key = itr.next();
            keysStmt.append(","+key);
            valuesStmt.append(attributes.get(key)+",");          
        }

       //remove last comma
       valuesStmt = new StringBuffer(valuesStmt.toString().substring(0,valuesStmt.length-1));

       sql = keysStmt.append(")")+valuesStmt.append(")");

    } catch (Exception e) {
        LOG.error(e);
    }

}