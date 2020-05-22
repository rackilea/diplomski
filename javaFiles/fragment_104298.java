public static int[] countPass(int[] num){
    int count = 0, counter=0;
    for (int i = 0; i < num.length; i++){
        if (num [i] >= 50) count++;
        else counter++;
    }
    return new int[]{count,counter};
}