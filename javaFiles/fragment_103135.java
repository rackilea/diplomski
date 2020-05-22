return Files.walk(Paths.get(qPath))
    .map(p -> p.getFileName().toString())
    .filter(name -> name.endsWith(".txt"))
    .map(name -> name.substring(0, name.length()-".txt".length()))
    .findFirst()
    .get();