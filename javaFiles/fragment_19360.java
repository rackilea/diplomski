public boolean checkCount(int[] array, int n) {
    int maxCount = 0;
    Map<Integer,Integer> numberCountMap = new HashMap<>();
    for(int i=0;i<array.length;i++){
        int number = array[i];
        int count = numberCountMap.getOrDefault(number,0);
        numberCountMap.put(number, ++count);
        if(count > maxCount){
            maxCount = count;
        }
    }
    if(maxCount >= n/3){
        return true;
    }else{
        return false;
    }
}