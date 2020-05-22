if (flag == '#' || flag == '$' || flag == '*' || flag == '&') {
    char last = ' ';
    char curr = ' ';
    int count = 1;
    for (int i = 0; i < s.length(); i++) {
        last = curr;
        curr = s.charAt(i);
        if (curr == last) {
            count++;
        } else if (last != ' ') {
            System.out.print(("" + count) + last);
            count = 1;
        }
    }
    System.out.print(("" + count) + last);
}