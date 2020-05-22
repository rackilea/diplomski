StringBuilder sb = new StringBuilder();
for (int i = 0; i < wordList.length; i++) {
    boolean found = false;
    for (int j = i+1; j < wordList.length; j++) {
        if (wordList[j].equals(wordList[i])) {
            found = true;
            break;
        }
    }
    // System.out.printf("Checking: [%s]%n", wordList[i]);
    if (!found) {
        if (sb.length() > 0)
            sb.append(' ');
        sb.append(wordList[i]);
    }
}
System.out.printf("Unique: [%s]%n", sb);