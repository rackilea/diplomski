int array[] = {1,2,3,3,3,4,5,6,6,7,8,8,10,10,11,12,13,13};

Set<Integer> uniqueValues = new HashSet<>();
Set<Integer> alreadyDisplayed = new HashSet<>();
for(Integer value : array) {
  if(uniqueValues.contains(value) && !alreadyDisplayed.contains(value)) {
    System.out.println(value);
    alreadyDisplayed.add(value);
  }
  uniqueValues.add(value);
}