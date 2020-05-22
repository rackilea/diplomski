String word = "There is a boy's puppy. Really?";
String[] res = word.split("(\\s+)|(?=[\\.\\?])");

for (String s: res ) {
    System.out.print("[" + s + "]");
}