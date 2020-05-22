List<List<Integer>> list = Arrays.asList(Arrays.asList(10, 5, 4), 
        Arrays.asList(3, 2, 1), Arrays.asList(7, 8, 6));
for (List<Integer> l : list) {
    Collections.sort(l);
}
Collections.sort(list, new Comparator<List<Integer>>() {
    public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(0).compareTo(o2.get(0));
    }
});
System.out.println(list);