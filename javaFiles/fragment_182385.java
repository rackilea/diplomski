public static void main(String[] args) {
  String b="Name=Paul Roberts|Telephone=|Address=|City=LA";

  for (String s : b.split("\\|")) {
    String[] pair = s.split("=");

    String attribute = pair[0];
    String value = ((pair.length > 1) ? pair[1] : "");

    System.out.println("Attribute=" + attribute);
    System.out.println("Value=" + value);
    System.out.println();
  }
}