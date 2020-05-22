String[][] stringArrays = new String[][] {
    {"error message 1", "fail"},
    {"error message 2", "N/A"},
    {"error message 1", "fail"}, // duplicate
    {"error message 2", "fail"}
};

Set<List<String>> uniqueSet = new HashSet<List<String>>();
for (String[] a : stringLists) {
    uniqueSet.add(Arrays.asList(a));
}
// uniqueSet.size() should return 3 here