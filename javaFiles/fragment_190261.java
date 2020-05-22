public static void main(String args[]) {
  String s = "[Munich, Germany],[Jingle Pot Rd, Nanaimo, BC, Canada]";
  List<String> ss = getStringsInBrackets(s);
  ss.get(0); // => "Munich, Germany"
  ss.get(1); // => "Jingle Pot Rd, Nanaimo, BC, Canada"
}