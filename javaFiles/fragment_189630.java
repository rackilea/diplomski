Statement select = conn.createStatement();
ResultSet result = select.executeQuery("SELECT * FROM D724933.ECOCHECKS WHERE ECO = '"+localeco+"' AND CHK_TOOL = '"+checknames[i]+"'");
ResultSetMetaData rsmd = result.getMetaData();

int numberOfColumns = rsmd.getColumnCount();    
List data = new ArrayList<Map>();
Map mapp2;

while(result.next()) { // process results one row at a time
    mapp2 = new HashMap<String, String>();
    for(int i=1; i<=numberOfColumns; i++) {
        mapp2.put(rsmd.getColumnName(i), rs.getString(i));
    }
    data.add(mapp2);
}