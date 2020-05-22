public static List<String> removeDuplicates(List<String> list) {
    List<String> result = new ArrayList<>();
    result.addAll(list);

    for (String word : list) {
        String words = word + "s";
        result.remove(words);
    }
    return result;
}