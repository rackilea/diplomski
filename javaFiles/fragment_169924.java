int length = 0;
for (int i = 0; f.ready(); i++) {
    int character = f.read();
    String s = c.toBinaryString(character) + " ";

    length += s.length();
    if (length > 80) {
        s += "\n";
        length = 0;
    }
    System.out.print(s);
}