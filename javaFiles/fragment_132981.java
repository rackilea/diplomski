Transformer t = new Transformer(...);

list.stream()
            .filter(Objects::nonNull)
            .map(Student::getName)
            .map(t::transform)
            .collect(Collectors.toSet());