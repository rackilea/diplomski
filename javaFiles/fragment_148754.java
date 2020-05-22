files.stream()
  .map(f -> {
      try {
          return generateMarkdown(f);
      } catch (IOException e) {
          failed.add(f);
      }
      return null;
  })
  .filter(Objects::nonNull)
  .forEach(h -> { ...