for (int i = 0; i < arr.length; i++) {
    final int[] arrFinal = arr;
    final int iFinal = i;
    List<Integer> res = IntStream.of(arr).boxed()
        .filter(x -> x + arrFinal[iFinal] == givenNumber)
        .collect(Collectors.toList());
}