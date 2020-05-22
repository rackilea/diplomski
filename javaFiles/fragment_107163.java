public static void main(String[] args) {
    Properties properties = new ExpandingProperties();
    properties.put("myVar", "myLongExpression");
    properties.put("foo", "${myVar}_1");
    properties.put("bar", "${foo}_abc");

    System.out.println(properties.getProperty("bar"));
}