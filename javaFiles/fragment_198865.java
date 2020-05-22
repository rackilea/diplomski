Arrays.sort(array); //sorts the array elements in ascending order
int i,j,lastNum;
ArrayList<Integer> list = new ArrayList<Integer>();

for(i=0,j=i+1;i<array.length-1;i++,j++) {
  if(!list.isEmpty()) {
    lastNum = list.get(list.size()-1);
  } else {
    lastNum = array[i]-1; // so that compiler doesn't warn you about lastNum not being initialized
  }
  if(array[i]!=lastNum) {
      if(array[i]==array[j]) {
        list.add(array[i]);
      }
  } else {
    continue;
  }
}

Iterator<Integer> it = list.iterator();

while(it.hasNext()) {
    System.out.println(it.next().intValue());
}