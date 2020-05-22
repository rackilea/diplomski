int keyWordIndex = 0; //moves only when needed
boolean allMatch = true;
for(String word : phrase){
   if(keywords.contains(word)){
      allMatch &= (word.equals(keyword.get(keyWordIndex++));
   }
}

//if allMatch is true at this point the order is respected.