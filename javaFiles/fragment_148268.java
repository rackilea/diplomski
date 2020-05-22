public ArrayList<Integer> withinRange(int min, int max, int[]array){
    ArrayList<Integer> list = new ArrayList<>();

    for(int i : array){
        if(i>=min && i<=max){
            list.add(i);
        }
    }
    return list;
}