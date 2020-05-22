Map<String, Set<String>> map = new LinkedHashMap<>();
arr1.forEach(foo -> 
        foo.someList.forEach(s -> 
                map.computeIfAbsent(
                    s, 
                    k -> new LinkedHashSet<>())
                .add(foo.someString)));