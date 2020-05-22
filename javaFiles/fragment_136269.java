String jsonData = "{\n"
    + "    \"TEST\": {\n"
    + "        \"NAME\": \"PART_TRAN\",\n"
    + "        \"VERSION\": \"9.0\",\n"
    + "        \"ID\": \"----\",\n"
    + "        \"SEGMENT\": {\n"
    + "            \"TYPE\": \"R\",\n"
    + "            \"CLIENT_ID\": \"----\",\n"
    + "            \"UN_NUM\": \"UN\"\n"
    + "        }"
    + "    }"
    + "}";
    Map<String, Object> jsonObject = U.fromJsonMap(jsonData);
    String type = U.<String>get(jsonObject, "TEST.SEGMENT.TYPE");
    String unNum = U.<String>get(jsonObject, "TEST.SEGMENT.UN_NUM");
    System.out.println(type);
    System.out.println(unNum);