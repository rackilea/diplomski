String lastWord = "";
while (read.hasNext()) {
    String s = read.next();
    if (lastWord.compareToIgnoreCase(s) < 0)
        lastWord = s;
}