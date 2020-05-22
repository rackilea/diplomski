String photoRoot = "http://someurl/${TOKEN1}/${TOKEN2}";
String startDelimiter = "${";
char endDelimiter = '}';
int start = -1, end = -1;
while (true) {
    start = photoRoot.indexOf(startDelimiter, end);
    end = photoRoot.indexOf(endDelimiter, start + startDelimiter.length());
    if (start != -1 && end != -1) {
        System.out.println(photoRoot.substring(start + startDelimiter.length(), end));
    } else {
        break;
    }
}