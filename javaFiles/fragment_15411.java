List<Path> matches = new ArrayList<>();
    List<Path> files = List.of();
    for (Path p : files) {
        new Thread(() -> {
            if (1 == 1) {
                matches.add(p);
            }
        }).start();
    }