String lastWord = null;
while (readfile.hasNextLine()) {
    String[] words = readfile.nextLine().split("\\s");
    if (lastWord != null) {
        phraseSet.add(lastWord + " " + words[0]);
    }
    for (int i=0; i<words.length-1; i++) {
        phraseSet.add(words[i] + " " + words[i+1]);
    }
    lastWord = words[words.length-1];
}