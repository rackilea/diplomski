private String[] specialSplit(String s) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int parenCount = 0;
    for (int i = 1; i < s.length() - 1; i++) { // go from 1 to length -1 to discard the surrounding ()
        char c = s.charAt(i);
        if (c == '(') parenCount++;
        else if (c == ')') parenCount--;

        if (parenCount == 0 && c == ',') {
            result.add(sb.toString());
            sb.setLength(0); // clear string builder
        } else {
            sb.append(c);
        }
    }
    result.add(sb.toString());
    return result.toArray(new String[0]);
}