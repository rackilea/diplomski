public static void main(String[] args) {
    String s = "Color Red, Size 32 / Text text";
    Matcher matcher = Pattern.compile("\\d+").matcher(s);
    if (matcher.find()) {
      String find = matcher.group();
      Integer i = Integer.parseInt(find);
    }
}