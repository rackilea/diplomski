Map<Integer, List<Integer>> myMap = new HashMap<>();

for(int i = 0; i < numberOfColumnss; i++){
   List<Integer> myArrayList = new ArrayList<>();
   for(int j=0; j < numberOfRows; j++){
      myArrayList.add(myArray[j][i])
   }
   myMap.put(i, myArrayList)
}