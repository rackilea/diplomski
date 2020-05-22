map.forEach((name, lines) -> {
    try {
       Files.write(Paths.get(name + ".results.txt"), lines);
    } catch (IOException e) {
       // do whatever
    }
});