static ArrayList<ArrayList<Integer>> deepCopy(ArrayList<ArrayList<Integer>> orig) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    for (ArrayList<Integer> inner : orig) {
        res.add(new ArrayList<Integer>(inner));
    }
    return res;
}