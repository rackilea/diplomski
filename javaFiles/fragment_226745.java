ResultSet result = selectStmt.executeQuery();
HashMap<String, String> resultValues;
while (result.next()) {
    resultValues = new HashMap<String, String>();
    resultValues.put("PARTC_ID", result.getString("PARTC_ID"));
    resultValues.put("FILE_NME", result.getString("FILE_NME"));
    resultValues.put("LOC_ID", result.getString("LOC_ID"));
    resultValues.put("CRTE_DTE", result.getString("CRTE_DTE"));
    resultValues.put("CRTE_BY", result.getString("CRTE_BY"));
    value.add(resultValues);
    System.out.println(value);
}