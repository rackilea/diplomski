private static boolean twoNumbersInArraySumIsEqualToX(int[] input, int x) {
    //create HashSet and store each element as key from array
    Set<Integer> set =  new HashSet<Integer>();
    for (int elem_ : input) set.add(elem_);

    //Iterate through the array and find if (x - elem) exists in set
    for (int elem_ : input) {
      if(set.contains(x - elem_)) return true;
    }
    return false;
  }