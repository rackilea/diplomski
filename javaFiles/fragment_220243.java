public static void duplicate(int numbers[], int size)
{
  for (int i = 0; i < size; i++){
    boolean duplicate = false;
    int b = 0;
    while (b < i){
      if (numbers[i] == numbers[b])
         duplicate = true;
      b++;}
    if (duplicate == false)
      System.out.print(numbers[i] + " ");}
}