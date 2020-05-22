public ArrayList<Integer> getList(){
    ArrayList<Integer> result = new ArrayList<Integer>();

    for(ArrayList<Integer> i : list_){
        result.addAll(i);
    }
    return result;
}