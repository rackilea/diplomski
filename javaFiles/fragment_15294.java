while(!myList.isEmpty()) {
  double lowestRandom = 1.0;
  int lowestIndex; //for efficient removal, save index instead of element
  for(int i = 0; i < myList.size(); i++) {
    double random = Math.random();
    if(random < lowestRandom) {
      lowestRandom = random;
      lowestIndex = i;
    }
  }
  myList.remove(lowestIndex);  
}