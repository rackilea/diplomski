Map<String, String> m = new HashMap<>();
    ImmutableSet<Map.Entry<String, String>> uniqueKey = FluentIterable.from(new ArrayList<String>(Arrays.asList(arr)))
            .transform(new Function<String, Map.Entry<String, String>>() {
                @Override
                public Map.Entry<String, String> apply(String s) {
                    String[] splited = s.split("=");
                    return new KeyEntry(splited[0], splited[1]) {
                    };
                }
            }).toSet();

    for (Map.Entry<String, String> s : uniqueKey) {
        m.put(s.getKey(), s.getValue());
        System.out.println(s);
    }