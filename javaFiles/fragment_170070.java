public void greaterCounter(List<Integer> input){
  for (Integer i : input){
    Integer count = 0;
    for (Integer j : input){
      if (i < j)
        count++;
    }
    System.out.print(i+","+count+" ");
  }
}