int[] starts = IntStream.range(0, solutions.size())
                            .filter(i -> solutions.get(i).question.equals("Index1"))
                            .toArray();
    if (starts.length < 2) {
        // not sure what you want to do in this case
    } else {
        List<Solution> lastTwoSets = solutions.subList(starts[starts.length-2], solutions.size());
        lastTwoSets.forEach(System.out::println);
    }