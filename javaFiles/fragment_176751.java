public static void main(String[] args) {
    String s = "\\sbas  def";
    System.out.println(s);
    System.out.println(s.replaceAll("\\s+", ""));
    System.out.println(s.replaceAll("\\\\s+", ""));

}