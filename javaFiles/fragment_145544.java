public static List<Integer> process(List<Integer> data, List<Integer> indexList) {
    int n = data.size();
    int[]result = new int[n];
    int max = data.get(n - 1);
    int count = 1;
    result[n - 1] = 1;
    for(int i = n - 2; i >= 0; i--){
         if(max == data.get(i)){
            count++;
         }else if(max < data.get(i)){
            max = data.get(i);
            count = 1;
         }
         result[i] = count;
    }
    // Populate result
    List<Integer> list = new ArrayList<>();
    for(int i : indexList){
        list.add(result[i]);
    }
    return list;
}