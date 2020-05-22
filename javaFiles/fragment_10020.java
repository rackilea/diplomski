int lastSize = 0;
for (;;) {
    int nextSize = determineNextSize(lastSize, input);
    if (nextSize <= lastSize) {
        break;
    }
    StringBuilder words = new StringBuilder();
    collectUniqueWordsOfLength(input, nextSize, words);
    lastSize = nextSize;
    System.out.print(words + lastSize + " ");
}
System.out.println();