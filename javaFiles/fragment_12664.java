// this List of lists will need to contain 
// all of the ArrayLists you would like to sort
List<ArrayList> allTheLists; 
Collections.sort(allTheLists, new Comparator<ArrayList>(){
    public int compare(ArrayList a1, ArrayList a2) {
        return a2.size() - a1.size(); // assumes you want biggest to smallest
    }
});