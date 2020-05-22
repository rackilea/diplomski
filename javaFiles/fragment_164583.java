int abs(int x){
    return x>0?x:-x;
}

int palindromeCounts(String str){
    int count = 0;

    for(int idx = 0; idx < str.length()/2; idx++)
        count += abs(str.charAt(idx) - reverse.charAt(str.length()-1-idx));

    return count;
}