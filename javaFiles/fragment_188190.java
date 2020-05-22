pairRdd2.groupByKey().filter(f -> {
        Set<String> set = new HashSet<>();
        for(String s: f._2())
            set.add(s);

        return list.containsAll(set);
    });