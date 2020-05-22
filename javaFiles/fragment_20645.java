List<String> fragments(String[] words) {
    var result = new ArrayList<String>();
    for (var i = 0; i < words.length; i++) {
        for (var j = words.length; j > i; j--) {
            var fragment = new StringBuilder();
            for (var k = i; k < j; k++) {
                if (k > i) {
                    fragment.append(" ");
                }
                fragment.append(words[k]);
            }
            result.add(fragment.toString());
        }
    }
    // result.remove(0);  // if you dont want the whole sequence inside the result
    return result;
}