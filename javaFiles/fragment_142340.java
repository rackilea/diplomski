Collectors.toMap(
        plugin -> plugin.getId(),
        plugin -> new
                PatternWrapper(plugin.getId(), Pattern.
                compile(plugin.getValue())),
        (left, right) -> left,
        LinkedHashMap::new);