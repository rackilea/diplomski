String keyOneValue = map.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().size()==1)
                        .findFirst()
                        .get()
                        .getKey();