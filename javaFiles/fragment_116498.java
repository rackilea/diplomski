StringBuilder build = new StringBuilder();
int current = 0;
for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    if (c == ' ') {
        build.append(' ');
        current = i + 1;
    } else {
        build.insert(current, c);
    }
}
return build.toString();