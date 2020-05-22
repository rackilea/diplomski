List<Integer> starts = IntStream.range(0, solutions.size())
                                    .filter(i -> solutions.get(i).getQuestion().equals("Index1"))
                                    .boxed()
                                    .collect(toList());
    if (starts.size() < 2) {
        // not sure what you want to do in this case
    } else {
        List<Solution> lastTwoSets = solutions.subList(starts.get(starts.size()-2), solutions.size());
        lastTwoSets.forEach(System.out::println);
    }