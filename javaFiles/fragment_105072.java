public static Collection<Rational> sort(List<Rational> list){
  List<Rational> sortedList = new ArrayList<Rational>();

  for (int i=0;i < rationalList.size();i++) {
     Rational currentValue = rationalList.get(i);

     int pos = sortedList.size(); // default is to the end of the list
     for (int j=0;j<sortedList.size();j++) {
        int comparison = currentValue.compareTo(sortedList.get(j))
        //this is the right position if the currentValue is greater or equal 
        //to the sorted value at this position
        if(comparison > 0 || comparison == 0){
           pos = j;
           break;
        }
     }
     sortedList.add(pos, currentValue);
  }
  return sortedList;
}