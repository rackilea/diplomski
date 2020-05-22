List<ArrayList<Integer>> result = nested.stream()
        .map(list -> {
            list.add(100);
            return list;
        })
        .collect(Collectors.toList());