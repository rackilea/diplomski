private static List<String> getCombinations(String input) {
    ArrayList<String> result = new ArrayList<String>();
    int len = input == null ? 0 : input.length();
    for (int i = 0; i < len - 1; i++) {
        for (int j = i + 1; j < len; j++) {
            String combination = String.valueOf(input.charAt(i))
                    + input.charAt(j);
            System.out.println("adding: " + combination);
            result.add(combination);
        }
    }
    return result;
}