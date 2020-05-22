IntStream.range(0, aList.size())
    .parallel()
    .forEach(i -> {
        if (i < bList.size()) aList.get(i).doSomethingWith(bList.get(i));
        else aList.get(i).doSomething();
    });