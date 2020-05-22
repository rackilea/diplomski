Map<String, List<String>> map = new HashMap<>();
    map.put("Greeting", Arrays.asList("Hello", "World"));
    map.put("Farewell", Arrays.asList("Goodbye", "Suckers"));

    map.entrySet().stream()
            .flatMap(entry -> 
                    entry.getValue().stream()
                            .map(s -> new AbstractMap.SimpleEntry<>(entry.getKey(), s)))
            .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));