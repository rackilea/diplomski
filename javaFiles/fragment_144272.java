ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

Integer[][] result = new Integer[adjList.size()][];//create your array of arrays
for (int i = 0; i < adjList.size(); i++) {
    //foreach array you have to inisialize it with the correct size
    result[i] = new Integer[adjList.get(i).size()];

    //the fill the array with the value of your list
    for(int j = 0; j < adjList.get(i).size(); j++){
        result[i][j] = adjList.get(i).get(j);
    }
}