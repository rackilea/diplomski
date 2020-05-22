Map<String, Map<FileId, List<PositionInFile>>> wordsWithLocations;

for (int j = 0; j < wordList.length; j++) {
   if (!wordList[j].isEmpty()){
      if (!wordsWithLocations.containsKey(wordList[j])) {
         Map<FileId, List<PositionInFile>> map = new HashMap<>();
         List<PositionInFile> list = new ArrayList<>();
         list.add(wordPosition[j]);
         map.put(fileId, list);
         wordsWithLocations.put(wordList[j], map);
       } else {
          Map<FileId, List<PositionInFile>> map = 
                          wordsWithLocation.get(wordList[j]);
          if (map.contains(fileId)) {
             map.get(fileId).add(wordPosition[j]);
          } else {
             List<PositionInFile> list = new ArrayList<>();
             list.add(wordPosition[j]);
             map.put(fileId, list);
          }
       }
    }
}

...

for (String word : wordsWithLocation) {
   int nAppearances = 0;
   for (List<PositionInFile> positions :      
                            wordsWithLocation.get(word).values()) {
      nAppearances += positions.size();
   }
   System.out.println(word + " appears " + nAppearances + " times.");
}