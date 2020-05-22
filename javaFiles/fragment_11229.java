String buffer = aVeryLongString;
String[] splitStringArray = buffer.split(regex);

int offset = -1;
for(String s: splitStringArray) {
    offset = buffer.indexOf(s, offset + 1); // avoid duplicates
    System.out.println(offset);
}