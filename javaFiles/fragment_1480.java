void foo(String fullFileName) {
    // 1
    Path source = Paths.get(fullFileName + ".tmp");
    // 2
    Path target = Paths.get(fullFileName);
    // 3
    Files.delete(target);
    // 4
    Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
    // 5
}