if (!wordMap.containsKey(newText)) {
  final HashMapWritable<Text, ArrayListOfIntsWritable> fileMap = new HashMapWritable<Text, ArrayListOfIntsWritable>;
  final ArrayListOfIntsWritable wordPosition = new ArrayListOfIntsWritable();
  wordPosition.add(c);
  fileMap.put(INPUTFILE, wordPosition);
  wordMap.put(newText, fileMap);                    
} else {
  final HashMapWritable<Text, ArrayListOfIntsWritable> fileMap =
      wordMap.get(newText);
  final ArrayListOfIntsWritable wordPosition = fileMap.get(INPUTFILE);
  wordPosition.add(c);
}