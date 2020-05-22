static int add(ArrayList<ArrayList<Integer>> inputList) {
    int sum = 0;
    for(ArrayList<Integer> nestedList : inputList) {
        for (int n : nestedList) sum += n;
    }

    return sum;
}