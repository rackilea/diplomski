public String countOccurences(String letter,List<String> array){
  int counter = 0; 
  for(String s : array){
      if(s.equals(letter))
        counter++;
   }
  return letter + ": " + String.valueOf(counter);
}

public void getResult(List<String> array){
  Set<String> setOfLetters = new HashSet<String>();
  List<String> dataArray = new ArrayList<String>();
  for(String s: array){
     s.replace("[","");
     s.replace("]","");
     String tab[] = s.split(",");
     setOfLetters.add(tab[0]);
     dateArray.add(tab[0]);
 }
 for(String s: setOfLetters)
    countOccurences(s,dataArray);
}