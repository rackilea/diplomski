String s = "text (255)";
int start = s.indexOf('(')+1;
int end = s.indexOf(')', start);
if (end < 0) {
    // not found
} else {
    int num = Integer.parseInt(s.substring(start, end));
}