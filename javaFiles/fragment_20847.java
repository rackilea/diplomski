int array[] = {1,2,3,3,4,5,6,6,7,8,8,10,10,11,12,13,13};

for (int i = 0; i < array.length; i++) {
  for (int j = 0; j < array.length; j++) {
    if (array[i] == array[j] && i != j){
      System.out.println(array[i]);
    }
  }
}