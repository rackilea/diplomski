Arrays.stream(str.split("[.!?]"))
      .map(String::trim)
      .filter(s -> !s.isEmpty()) 
      .mapToInt(s -> s.split("\\s+").length)
      .max()
      .orElse(0);