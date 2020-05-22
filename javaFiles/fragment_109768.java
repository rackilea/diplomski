List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    for (int number : numbers) {
        if (isEven(number)) {
            process(number);
        }
    }