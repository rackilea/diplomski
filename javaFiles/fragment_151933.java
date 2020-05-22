@SuppressWarnings("unchecked")
    final List<Foo>[] permutedList = permuted.toArray(new List[10]);
    final Foo[][] permutedArray = new Foo[10][10];
    for (int j = 0; j < 10; ++j) {
        permutedArray[j] = permutedList[j].toArray(new Foo[10]);
    }