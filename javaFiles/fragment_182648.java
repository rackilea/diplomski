List<String> citiesToRemove = Arrays.asList(
        "greenville, sc",
        "pensacola, fl",
        "peoria, il",
        "asheville, nc",
        "hattiesburg, ms",
        "portland, me",
        "huntsville, al",
        "reading, pa",
        "birmingham, al",
        "bloomington, in",
        "bowling green, ky",
        "lafayette, la",
        "central atlantic coast, fl",
        "lancaster, pa",
        "charleston, sc",
        "charleston, wv",
        "san juan, pr",
        "london, ont",
        "springfield, il",
        "columbia, mo",
        "columbia, sc",
        "montgomery, al",
        "morgantown, wv",
        "fayetteville, ar",
        "wilmington, nc",
        "outer banks,nc");

List<String> filteredListOfCities = NoUber_cities.stream()
        .filter(item -> !citiesToRemove.contains(item.toLowerCase()))
        .collect(Collectors.toList());