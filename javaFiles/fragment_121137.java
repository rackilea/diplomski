List<String> result = new ArrayList<>(list1);
    for (String list2Member : list2) {
        if (result.stream().anyMatch(s -> s.startsWith(list2Member))) { // includes case where list2Member is in result
            // skip
        } else {
            OptionalInt resultIndex = IntStream.range(0, result.size())
                    .filter(ix -> list2Member.startsWith(result.get(ix)))
                    .findAny();
            if (resultIndex.isPresent()) {
                result.set(resultIndex.getAsInt(), list2Member);
            } else {
                result.add(list2Member);
            }
        }
    }