Character[][] maze = Files.lines(Paths.get(stringPathOrUri))
      .map(s -> s.split(","))
      .map(strings -> Stream.of(strings)
                            .map(s -> s.charAt(0)) // better: insert your transformation function here
                            .toArray(Character[]::new))
      .toArray(Character[][]::new);