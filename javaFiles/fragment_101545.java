// Note: fixed case of class. Please follow Java naming conventions
Graph(int n){
    adjLst = new LinkedList<Integer>[n];
    for (int i = 0; i < n; i++) {
        adjLst[i] = new LinkedList<Integer>();
    }
}