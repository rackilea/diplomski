public void increment(int increment1, int increment2, int increment3)
{
    int[] array = {increment1, increment2, increment3};

    for(int i = 1; i < array.length; i++){
      array[i] = 1;
    }
}