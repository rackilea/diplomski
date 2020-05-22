// a unique counter across restarts
final AtomicLong counter = new AtomicLong(System.currentTimeMillis()*1000);

private void createCache(String templatePath, String cachePath) {
    //get template
    String temp = getTemplate(templatePath);

    Path path = Paths.get(cachePath);
    Path tmpPath = Paths.get(path.getParent().toString(), counter.getAndIncrement() + ".tmp");
    // save cache file
    Files.write(tmpPath, temp.getBytes(StandardCharsets.UTF_8));
    Files.move(tmpPath, path, ATOMIC_MOVE, REPLACE_EXISTING);
}