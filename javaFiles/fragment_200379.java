List<String> acc = IntStream
            .range(0, list.size())
            .filter(i -> ((i < list.size() - 1 && !list.get(i).equals(list
                    .get(i + 1))) || i == list.size() - 1))
            .mapToObj(i -> list.get(i)).collect(Collectors.toList());
System.out.println(acc);