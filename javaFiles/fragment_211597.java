String str = "a b c d e";
String newStr = "";
for (int i=0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (ch != 32)
        newStr += ch;
}
System.out.println(newStr);