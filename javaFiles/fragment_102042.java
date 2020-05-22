public static ArrayList<String> writeTimeSheetJSONCDR(JSONArray dayEntries) {
        try {
            ArrayList<String> cdrRows = new ArrayList<String>();
            StringBuilder cdrEntry = new StringBuilder();
            for (int i = 0; i < dayEntries.length(); i++) {
                JSONObject jsonDayEntry = (JSONObject) dayEntries.get(i);


                Iterator iterator = jsonDayEntry.keys();

                while (iterator.hasNext()){
                    String key =(String) iterator.next();
                    cdrEntry.append(jsonDayEntry.get(key)).append(",");
                }

                cdrRows.add(cdrEntry.toString());
            }
            System.out.println("CDREntry: " + cdrEntry.toString());
            return cdrRows;
        } catch (Exception exp) {
            System.err.println("Error parsing json" + exp);
            return null;
        }
    }