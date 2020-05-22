public static void main(String[] args) {
    String s = "{\"regular\":\"a\", \"sensitive\":\"b\"}";
    String key = "sensitive";
    String val = "****";
    System.out.println(s.replaceAll("(?<=\"" + key + "\":\")(\\w+)", val));
     key = "regular";
    System.out.println(s.replaceAll("(?<=\"" + key + "\":\")(\\w+)", val));

}