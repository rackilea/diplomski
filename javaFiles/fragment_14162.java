HashMap<String, HashMap<String, HashMap<String, String>>> hash =
    new HashMap<String, HashMap<String, HashMap<String, String>>>();

hash.put("AREA_CODE", new HashMap<String, HashMap<String, String>>());
hash.get("AREA_CODE").put("PHONE", new HashMap<String, String>());
hash.get("AREA_CODE").get("PHONE").put("STREET_ADDR", "221B Baker Street");

System.out.printf("Street address is %s\n",
    hash.get("AREA_CODE").get("PHONE").get("STREET_ADDR"));