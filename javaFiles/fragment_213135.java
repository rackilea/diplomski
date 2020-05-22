out = new StringTokenizer(input.toString());
int count = out.countTokens():
List<String> wordList = new ArrayList<String>(count);
for(int i = 0; i < count; i++) {
    wordList.add(out.nextToken());
}
Collections.sort(wordList);