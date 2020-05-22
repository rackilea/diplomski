public static int range(int[] list){

    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    for(int i = 0; list != null && i < list.length; i++){
        int current = list[i];

        if(current > max){
             max = current;
        }

        if(current < min){
             min = current;
        }
    }

    if(max >= min){
        return max-min+1;
    }
    else throw IllegalArgumentException("Zero-length and null arrays have an undefined range!");
}