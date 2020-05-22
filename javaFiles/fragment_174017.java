List<List<Integer>> l1
        = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(7),
                Arrays.asList(4, 5, 6),
                Arrays.asList(8, 9),
                Arrays.asList(10));
List<List<Integer>> l2
        = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3, 7, 8),
                Arrays.asList(4, 5, 10),
                Arrays.asList(6, 9));
List<List<Integer>> intersect
        = l1.stream()
        .flatMap(sl1 -> l2.stream().map(sl2 -> {
            List<Integer> lout = new ArrayList<>();
            lout.addAll(sl1);
            lout.retainAll(sl2);
            return lout;
        }))
        .filter(l -> l.size() > 0)
        .distinct()
        .collect(Collectors.toList());