public int[] getSumOfEvensAndOdds(int[] input) {
    int even = 0, odd = 0;
    if(null != input){
        for (int i: input) {
            if (0 == i % 2){
                even += i;
            } else{
                odd += i;
            }
        }
    }
    return new int[]{even, odd};
}