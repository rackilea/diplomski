ArrayList<ArrayList<ArrayList<Integer>>> safeSquares = new ArrayList<ArrayList<ArrayList<Integer>>>();

for (int i = 0; i < 8; i++) {
    ArrayList<ArrayList<Integer>> squares = new ArrayList<ArrayList<Integer>>();
    for (int x = 0; x < 8; x++) {
        ArrayList<Integer> pair = new ArrayList<Integer>();
        pair.add(x);
        pair.add(i);
        squares.add(pair);
        }
    safeSquares.add(squares);
}

for (ArrayList<ArrayList<Integer>> outlist : safeSquares) {
    for (ArrayList<Integer> inlist : outlist) {
        System.out.print(inlist);
    }
    System.out.println();
}