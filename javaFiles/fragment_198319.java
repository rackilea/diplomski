String original = "something";

String[] escapes = new String[]{"&lt;", "&gt;"}; // add more if you need
String[] replace = new String[]{"<", ">"}; // add more if you need

String new = original;

for (int i = 0; i < escapes.length; i++) {
    new = new.replaceAll(escapes[i], replace[i]);
}