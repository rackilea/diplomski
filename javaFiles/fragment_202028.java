private int sumOfList(List<Integer> list) {
    return list.stream().mapToInt(i -> i).sum();
}

List<List<Integer>> sumListSort = listList.stream()
        .sorted(Comparator.comparingInt(SampleClass::sumOfList))
        .collect(Collectors.toList());