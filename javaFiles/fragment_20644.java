List<String> fragments(String[] words) {
    var result = new ArrayList<String>();
    for (var i = 0; i < words.length; i++) {
        for (var j = words.length; j > i; j--) {
            result.add(Arrays.stream(words, i, j).collect(Collectors.joining(" ")));
        }
    }
    // result.remove(0);  // if you don't want the whole sequence inside the result
    return result;
}