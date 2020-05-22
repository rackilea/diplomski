public static String BuildJson() throws JSONException
    {

        JSONObject map1 = new JSONObject();
        map1.put("startDate", "2013-01-01");
        map1.put("endDate", "2013-02-01");
        map1.put("columns", "mode , event");

        JSONObject map2 = new JSONObject();

        map2.put("selectionType", "smart");
        map2.put("selectionMatch", "123456789012");

        map1.put("selection",map2);

        System.out.println(map1.toString());

        return null;

    }