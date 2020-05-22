int[] str={1 , 2 , 3 ,4  ,5 ,3 ,5 , 4,3,43,1,33,4,5};
Arrays.sort(str);
for (int i = 1; i < str.length; i++) {
  if (str[i] == str[i - 1]) {
    System.out.println("Dupe: " + str[i];
  }
}