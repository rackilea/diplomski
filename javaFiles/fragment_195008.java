List<String> input = Arrays.asList("a", "b", "c", "d", "e");
    List<String> output = new ArrayList<>();

    List<String> arrayList = new ArrayList<>(input);
    for (int i = 0; i < arrayList.size(); i++) {
        String s = arrayList.get(i);
        output.add(s);
        if (i == 2) {                   // <<< MODIFY
            arrayList.add(0, "XXX");
        }
    }