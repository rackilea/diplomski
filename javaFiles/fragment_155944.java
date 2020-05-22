for (int i=1; i<wins.size(); i++){
  String current = wins.get(i);
  if (current.equals(wins.get(i-1))) {      
    count++;       
    if(count >= maxValue){
      maxValue = count;
      value = current;
    }
  } else {
    count = 0;
  }
}