List<Float> unordered = new ArrayList<>(Arrays.asList(3.2f, 1.0f, 7.5f, 3.2f, 0.8f));
    System.out.println(unordered); // [3.2, 1.0, 7.5, 3.2, 0.8]

    List<IndexedEntry<Float>> ordered = new ArrayList<>();
    for (int i = 0; i < unordered.size(); i++) {
        IndexedEntry<Float> entry = new IndexedEntry<>(i, unordered.get(i));
        ordered.add(entry);
    }
    Collections.sort(ordered);
    System.out.println(ordered); // [(0.8, 4), (1.0, 1), (3.2, 0), (3.2, 3), (7.5, 2)]