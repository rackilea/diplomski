Map<Integer, String> result = new HashMap<>();
    Sets.symmetricDifference(right.entrySet(), left.entrySet())
            .stream()
            .forEachOrdered(x -> {
                String previousValue = result.putIfAbsent(x.getKey(), x.getValue());
                if (previousValue != null) {
                    result.replace(x.getKey(), right.get(x.getKey()));
                }
            });