void processCombinations(int[] pos, int n, ArrayList<ArrayList<String> > inputs, String[] soFar) {
    if (n == pos.length) {
        Process(soFar);
        return;
    }
    ArrayList<String> input = inputs.get(n);
    for (pos[n] = 0 ; pos[n] != input.size() ; pos[n]++) {
        soFar[n] = input.get(pos[n]);
        processCombinations(pos, n+1, input, soFar);
    }
}