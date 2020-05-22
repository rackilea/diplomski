int numStrings = strings.size();
List<String> result = new ArrayList<>(numStrings);
for (int i = 0; i < numStrings; ++i) {
    StringBuilder sb = new StringBuilder();
    for (String s : strings) {
        if (i < s.length) {
            sb.append(s.charAt(i));
        }
    }
    result.add(sb.toString());
}