public static int sumRange(int i1, int i2){
    if (i1<0 || i2<i1){
      return -1;
    }

    int sum = 0;
    for(int i = i1; i <= i2; i++){
        sum = i + sum;

    }
    return sum;


}