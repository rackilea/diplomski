terrorists.parallelStream().
        map(t -> t.split("\\s+")).
        map(t -> Stream.of(t).collect(toSet())).
        forEach(t -> {
            processedClients.parallelStream().forEach(c -> {
                if (t.containsAll(c)) {
                    System.out.println("Match found t:" + t + ", c:" + c);
                }
            });
        });