Map<Resource, Map<String, Object>> result = pResolved
        .stream()
        .collect(groupingBy(Function.identity(),
                flatMapping(resource -> resource.getCapabilities().stream(),
                        flatMapping(cap -> cap.getAttributes().entrySet().stream(),
                                toMap(Map.Entry::getKey, Map.Entry::getValue)))));