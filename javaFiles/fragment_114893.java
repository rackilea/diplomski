int[] str={1 , 2 , 3 ,4  ,5 ,3 ,5 , 4,3,43,1,33,4,5};
HashSet<Integer> seen = new HashSet<Integer>();
for (int i: str) {
  if (seen.contains(i)) {
    System.out.println("Dupe: " + i);
  } else {
    seen.add(i);
  }
}