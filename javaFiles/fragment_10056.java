Collections.sort(lists, new Comparator<ArrayList<Integer>>(){
    public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int result = 0;
        for (int i = 0; i <= list1.size() - 1 && result == 0; i++) 
        {
            result = list1.get(i).compareTo(list2.get(i));
        }
        return result;
    }
});