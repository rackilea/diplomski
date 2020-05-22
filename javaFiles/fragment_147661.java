try (Stream<Path> paths = Files.walk(Paths.get(this.folderPath))) {
    List<Path> files = paths
            .filter(Files::isRegularFile)
            .collect(Collectors.toList());

    for (List<Path> batch : Lists.partition(files, 2000)) { // Lists from Guava, batch will be 2000 elements or less.
        List<Item> parsed = batch.stream().map(Parser::parse).collect(Collectors.toList());
        itemService.saveAll(parsed);
    }
}