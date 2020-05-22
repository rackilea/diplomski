String text = "HELLO HOW ARE YOU";
String value = "abc";

for(char c : value.toUpperCase().toCharArray()) {
    if (text.indexOf(c) != -1) {
        throw new Exception("NOT LETTERS");
    }
}