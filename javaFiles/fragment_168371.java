DataSource dataSource = componentInstanceService.getResource(componentResourceType);

String result;
try (Scanner scanner = new Scanner(dataSource.getInputStream(), StandardCharsets.UTF_8)) {
    result = scanner.useDelimiter("\\z").next();
}