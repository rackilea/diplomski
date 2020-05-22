public static List<List<Integer>> generateCombinations(List<Integer> original, Deque<Integer> toAdd) {
    if (toAdd.isEmpty()) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(original);
        return res;
    }

    int element = toAdd.pop();
    List<List<Integer>> res = new LinkedList<>();
    for (int i=0 ; i<=original.size() ; i++) 
        // you must make a copy of toAdd, otherwise each recursive call will perform
        // a pop() on it and the result will be wrong
        res.addAll(generateCombinations(insertAt(original,element,i),new LinkedList<>(toAdd)));
    return res;
}

// a helper function for a clear code
public static List<Integer> insertAt(List<Integer> input, int element, int index) {
    List<Integer> result = new ArrayList<>(input);
    result.add(index,element);
    return result;
}