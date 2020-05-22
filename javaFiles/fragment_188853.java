private static void solve(List<List<String>> x, int item, List<String> combination) {
    if (item == x.size()) { // We have reached the end of the list i.e, traversed all rows 
        result.add(combination);
        return;
    }

    for (int i = 0; i < x.get(item).size(); i++) {
        List<String> current = new ArrayList<>(combination);
        current.add(x.get(item).get(i));
        solve(x, item + 1, current);
    }
}