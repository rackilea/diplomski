public static void someFunction(int[] num1, int count){

    if (count!= 0){
        num1[0] = 999;
        someFunction(num1, count-1);
    }
}