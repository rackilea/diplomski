unicorns.stream()
        .flatMap(unicorn -> unicorn.getRiders()
                .stream()
                .filter(rider -> rider.getType() == Rider.Type.EXPERIENCED)
                .map(rider -> new AbstractMap.SimpleEntry<>(unicorn, rider)))
        .max(Comparator.comparingLong(entry -> entry.getValue().getRideTime()))
        .map(entry -> new ImmutablePair<>(entry.getKey(), entry.getValue()));