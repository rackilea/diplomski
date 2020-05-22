function IncrementOne(int array[], int maxArrayInt, int maxArrayLength) {
    int i = maxArrayLength - 1;
    bool c = false;
    do {
       int p = array[i];
       p = p + 1;
       c = p > maxArrayInt;
       if(c) 
          array[i] = 0;
       else 
          array[i] = p;
       i = i - 1;
    }
    while(c && i >= 0)
}