void generatePermutations(List<List<Character>> lists, List<String> result, int depth, String current) {
    if (depth == lists.size()) {
        result.add(current);
        return;
    }

    for (int i = 0; i < lists.get(depth).size(); i++) {
        generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
    }
}