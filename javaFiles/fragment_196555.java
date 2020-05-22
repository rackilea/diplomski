String value = "ibm";
Optional<String> key = map.entrySet().stream()
            .filter(e -> e.getValue().contains(value))
            .map(Entry::getKey)
            .findFirst();

System.out.println(key.get());