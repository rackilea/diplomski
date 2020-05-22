List<Map<String, Object>> processedAttributes = attributes.stream()
        .flatMap(
                attribute -> ((List<Map<String, Object>>) attribute
                        .get("subAttributes")).stream())
        .filter(subAttr -> !user.containsKey(subAttr.get("name"))
                && Boolean.TRUE.equals(subAttr.get("required")))
        .collect(Collectors.toList());