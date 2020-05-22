public void test_45551110() {
    List<Integer> originalList = Arrays.asList(1, 2, 4, 5, 7);

    List<List<Integer>> listOfLists = new ArrayList<>();
    originalList.stream().forEach(item -> getMatchedList(item, listOfLists).add(item));
    System.out.println(listOfLists);
}

static List<Integer> getMatchedList(Integer item, List<List<Integer>> listOfLists) {
    return listOfLists.stream().filter(a -> matched(a, item)).findAny().orElseGet(() -> {
        List<Integer> list = new ArrayList<>();
        listOfLists.add(list);
        return list;
    });
}