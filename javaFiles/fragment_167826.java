static List<List<String>> recursive(String str) {
    List<List<String>> result = new ArrayList<>();

    if (str.length() == 1) {
        result.add(new ArrayList<>());
        result.get(0).add(str);
        return result;
    }

    for (List<String> list : recursive(str.substring(1))) {
        List<String> append = new ArrayList<>(list);
        append.set(0, str.substring(0, 1) + append.get(0));
        List<String> add = new ArrayList<>(list);
        add.add(0, str.substring(0, 1));
        result.add(append);
        result.add(add);
    }
    return result;
}