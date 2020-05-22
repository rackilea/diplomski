public static void main(String[] args) throws ParseException {
    Object json = new JSONParser().parse(
            "{" +
            "  \"name\": \"a\"," +
            "  \"age\": 10," +
            "  \"number\": 254," +
            "  \"spezial\": [{" +
            "      \"name\": \"vip\"," +
            "      \"age\": 12," +
            "      \"number\": 134" +
            "  }, {" +
            "      \"name\": \"b\"," +
            "      \"age\": 56," +
            "      \"number\": 934" +
            "  }]" +
            "}");
    System.out.println(findValue(json, "vip"));
    System.out.println(findValue(json, "foo"));
}