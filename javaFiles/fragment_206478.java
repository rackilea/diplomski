String data = "[[[\"waves\",\"olas\",null,null,1]],null,\"es\",null,null,null,0.54545456,null,[[\"es\"],null,[0.54545456],[\"es\"]]]\n";
    JSONArray jsonArray = new JSONArray(data);
    JSONArray jsonArray1 = jsonArray.getJSONArray(0);
    JSONArray jsonArray2 = jsonArray1.getJSONArray(0);
    System.out.println(jsonArray2.getString(0));
    System.out.println(jsonArray2.getString(1));