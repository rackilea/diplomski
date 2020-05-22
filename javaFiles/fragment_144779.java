private int printSum(String original){
    int sum = 0;
    if(original!=null){
        char[] arr = original.toLowerCase().toCharArray();
        for(int x :arr){
            sum+= (x-96);
        }
    }
    return sum;
}