private int[][] asArray(List<List<Integer>> lists){
    int s1 = lists.size();
    int s2 = 0;
    for(List<Integer> sublist : lists){
        if(sublist.size() > s2)
            s2 = sublist.size();
    }

    int[][] arr = new int[s1][s2];
    for(int i = 0; i < lists.size(); i++){
        List<Integer> sublist = lists.get(i);
        for(int j = 0; j < sublist.size(); j++){
            arr[i][j] = sublist.get(j);
        }
    }
    return arr;
}