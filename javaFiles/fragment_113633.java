public static List<String> split(String orig) {
    List<String> splitted = new ArrayList<String>();
    int nextingLevel = 0;
    StringBuilder result = new StringBuilder();
    for (char c : orig.toCharArray()) {
        if (c == ',' && nextingLevel == 0) {
            splitted.add(result.toString());
            result.setLength(0);// clean buffer
        } else {
            if (c == '(')
                nextingLevel++;
            if (c == ')')
                nextingLevel--;
            result.append(c);
        }
    }
    // Thanks PoeHah for pointing it out. This adds the last element to it.
    splitted.add(result.toString());
    return splitted;
}