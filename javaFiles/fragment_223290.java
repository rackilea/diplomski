try {
    for (String location : locations) {
        String resolvedLocation = environment.resolveRequiredPlaceholders(location);
        Resource resource = resourceLoader.getResource(resolvedLocation);
        environment.getPropertySources().addFirst(new ResourcePropertySource(resource));
    }
}