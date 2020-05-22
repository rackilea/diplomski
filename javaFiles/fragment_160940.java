Observable.just(map)
        .map(stringObjectAMap -> stringObjectAMap.entrySet())
        .flatMapIterable(entries -> entries)
        .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().a))
        .toMap(e -> e)
        .subscribe(m -> {
            //do something with map
        });