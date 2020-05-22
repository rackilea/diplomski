hm.entrySet()
        .stream()
        .sorted(Comparator.comparing(me -> me.getKey().get(0)))
        .forEachOrdered(x -> {
            hm.remove(x.getKey());
            hm.put(x.getKey(), x.getValue());
        });

    hm.forEach((k, v) -> System.out.println("" + k + " -> " + Arrays.toString(v)));