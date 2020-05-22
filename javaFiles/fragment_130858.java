JSONObject jo = new JSONObject();
    Collection<JSONObject> items = new ArrayList<JSONObject>();

    JSONObject item1 = new JSONObject();
    item1.put("aDataSort", new JSONArray(0, 1));
    item1.put("aTargets", new JSONArray(0));
    items.add(item1);
    JSONObject item2 = new JSONObject();
    item2.put("aDataSort", new JSONArray(1, 0));
    item2.put("aTargets", new JSONArray(1));
    items.add(item2);
    JSONObject item3 = new JSONObject();
    item3.put("aDataSort", new JSONArray(2, 3, 4));
    item3.put("aTargets", new JSONArray(2));
    items.add(item3);

    jo.put("aoColumnDefs", new JSONArray(items));

    System.out.println(jo.toString());