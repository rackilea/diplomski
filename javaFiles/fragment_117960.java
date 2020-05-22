Collection<Wrapper> wrapperList = wrappers.stream()
        .collect(Collectors.toMap(Wrapper::getId, x -> x),
                (oldVal, newVal) -> {
                    oldVal.getElements().addAll(newVal.getElements());
                    return oldVal;
                }))
        .values();