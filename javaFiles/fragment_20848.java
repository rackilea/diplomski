int array[] = {1,2,3,3,4,5,6,6,7,8,8,10,10,11,12,13};

//Optionally
Arrays.sort(array);

Integer last = null;
for(int i = 0; i < array.length -1 ; i++) {
  if(array[i] == array[i+1] && (last == null || !last.equals(array[i]))) {
    System.out.println(array[i]);
    last = array[i];
  }
}