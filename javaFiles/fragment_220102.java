ResultSetMetaData rsmd = rs.getMetaData();
        int numColumns = rsmd.getColumnCount();

        while (rs.next()) {
        HashMap<String, Object> record = new HashMap<String, Object>();
        for (int i = 1; i < numColumns + 1; i++) {
            String columnName = rsmd.getColumnName(i);

            //MODIFIED BY LALIT RAO @ 29-07-2015
            //THE BELOW CODE DESERIALIZES THE JSON ARRAY AND HASH-VALUE INTO JAVA STRING FOR struts2-json jar to convert it back to json in  response.

            if (columnName.equalsIgnoreCase("sem_holdings") || columnName.equalsIgnoreCase("sem_votes_allowed") || columnName.equalsIgnoreCase("gc_even_desc")){

            System.out.println("Inside Map<String, ArrayList<HashMap<String,String>>> if block");
            Map<String, ArrayList<HashMap<String,String>>> retMap = new Gson().fromJson(rs.getString(columnName), new TypeToken<HashMap<String, ArrayList<HashMap<String,String>>>>() {}.getType());
                record.put(columnName, retMap);
            }
            else if (columnName.equalsIgnoreCase("sem_ev_id") || columnName.equalsIgnoreCase("uvp_even_id") || columnName.equalsIgnoreCase("gc_ev_id")){

            System.out.println("Inside List <String> else-if block");
            List <String> retList = new Gson().fromJson(rs.getString(columnName), new TypeToken<List<String>>() {}.getType());
                record.put(columnName, retList);
            }
            else
            record.put(columnName, rs.getObject(columnName));

        }
        out.add(record); // ArrayList out
        }