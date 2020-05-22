Collection<String> collection = new ArrayList<>();

        collection.add("data1");
        collection.add("data1");
        collection.add("data2");
        collection.add("data3");

        Set<String> set = new TreeSet<>();

        set.addAll(collection);
        collection.clear();
        collection.addAll(set);
        System.out.println(collection);