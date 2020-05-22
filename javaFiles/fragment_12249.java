HashSet<String> newHashSet = new HashSet<>();
for (String word : secondWordGroup.getWordArray())
    newHashSet.add(word);

for (String word : this.getWordArray())
    newHashSet.add(word);