list.stream()
    .flatMap(a -> {
        if (a instanceof B) {
            return Stream.of(((B) a).getName());
        } else {
            C c = (C) a;
            return c.getItems().stream().map(o::getName);
        }
    })
    ...