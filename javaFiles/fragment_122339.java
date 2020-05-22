filenames.map(Paths::get)
          .filter(Files::exists)
          .map(p -> {
        try {
            return Optional.of(Files.newBufferedReader(p));
        } catch (IOException e) {
            return Optional.empty();
        }
    })