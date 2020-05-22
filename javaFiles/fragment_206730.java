String s = "abcdeedcbfgf";

while (true) {
    String next = removeConsecutiveDuplicate(s);
    if (next.equals(s))
        break;
    s = next;
}