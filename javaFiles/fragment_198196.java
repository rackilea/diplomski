List<String> finalOutput = partitionedValues.get(Boolean.TRUE) // with upper case
        .stream()
        .sorted(Comparator.comparing(String::length)) // sorted by length
        .collect(Collectors.toList());

finalOutput.addAll(partitionedValues.get(Boolean.FALSE) // without uppercase
        .stream()
        .sorted(Comparator.naturalOrder()) // sorted naturally
        .collect(Collectors.toList()));