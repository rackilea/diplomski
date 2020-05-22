List<String> wordSet = stream
            .map(line -> line.split("[ .,;?!.:()]"))
            .flatMap(Arrays::stream)
            .map(String::toLowerCase)
            .sorted()
            .collect(Collectors.toList());