public int getTotalPeople(){
  int total = 0;
  for(int i =0; i < stops.length ; i++){
       total += stops[i].getnPeople();
  }
  return total;
}