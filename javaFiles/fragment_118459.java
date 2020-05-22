public static void someFunction(int[] num1, int count){

    if (count!= 0){
        int[] temp = {999};
        someFunction(temp, count-1);
    }
}