public ArrayList<HashMap<String,Object>> convertDynaBeanListToArrayList(List<DynaBean> theList) {
    ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>>();
    DynaProperty[] dynaProperties = null;
    for (Integer i=0;i<theList.size();i++) {
        DynaBean row = theList.get(i);
        HashMap<String,Object> resultRow=new HashMap<String,Object>();
        // each raw got the same column names, no need to fetch this for every line
        if (dynaProperties == null) {
            dynaProperties = row.getDynaClass().getDynaProperties();
        }
        for (Integer j=0;j<dynaProperties.length;j++) {
            String columnName=dynaProperties[j].getName();
            resultRow.put(columnName, row.get(columnName));
        }
        result.add(resultRow);
    }

    return result;
}