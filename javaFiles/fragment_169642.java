import static java.util.Arrays.asList;

List<List<Integer>> matchedPostions = asList(asList(1, 198, 200), asList(2, 50, 61));
Collections.sort(matchedPostions, new Comparator<List<Integer>>() {
    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        // Sort the lists using the starting position (second element in the list)
        return o1.get(1).compareTo(o2.get(1));
    }
});

System.out.println(matchedPostions);
// [[2, 50, 61], [1, 198, 200]]