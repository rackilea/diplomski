List<String> keywords = Arrays.asList("my", "key", "word");

    try (BufferedReader br = new BufferedReader(new FileReader("fileToRead"))) {
        //this is the filtered lines
        List<String> filteredLine = br.lines()
            .filter(line -> keywords.stream().anyMatch(line::contains))
            .collect(Collectors.toList());
    }