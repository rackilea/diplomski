public static int greatestCommonFactor(int a, int b){
    int i = 1 ;
    while (i >= 1 ){
        i++;
    }
    ArrayList<Integer> factor = new ArrayList<Integer>();
    if (a%i == 0 && b%i == 0){
        factor.add(i);  
    }
    else if (a%i <= 1 || b%i <= 1){
        Collections.sort(factor);
        List<Integer> topnum = factor.subList(factor.size() - 1, factor.size());

    }
    return topnum;
}