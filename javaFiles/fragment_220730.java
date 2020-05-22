String lastWord = "";
while (read.hasNext()) {
    String s = read.next().toLowerCase();
    if (lastWord.compareTo(s) < 0)
        lastWord = s;
}