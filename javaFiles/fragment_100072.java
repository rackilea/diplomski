public String[] splitString(String s) {
    List<String> results = new ArrayList<>();
    int start = 0;

    while (true) {
        int next = s.indexOf('-', start);

        if (next < 0) {
            break;
        }
        results.add(s.subString(0, next));
        results.add(s.subString(next + 1));
        start = next + 1;
    }

    return results.toArray(new String[results.size()]);
}