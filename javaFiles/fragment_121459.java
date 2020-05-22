JSONArray jsonArr = new JSONArray(lineRead);
    Vector<Vector<String>> dataList = new Vector<>();
    for (int i = 0; i < jsonArr.length(); i++) {

        JSONObject jsonObj = jsonArr.getJSONObject(i);
        Vector<String> data = new Vector<>();

        data.add(jsonObj.getString("FOODID"));
        data.add(jsonObj.getString("PRICE"));
        data.add(jsonObj.getString("NUM"));
        data.add(jsonObj.getString("RES"));

        dataList.add(data);
    }

    Vector<String> columnNames = new Vector<>();
    columnNames.add("foodId");
    columnNames.add("price");
    columnNames.add("num");
    columnNames.add("res");

    JTable table = new JTable(dataList, columnNames);