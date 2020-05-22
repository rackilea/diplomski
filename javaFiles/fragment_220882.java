static void parseQuestionAndMaths(String input) {
    Pattern p = Pattern.compile("\\G__ELEMENT:\\h*(question|maths)\\h*\\R" +
                                   "____Text:\\h*(.*)\\R?");
    int end = 0;
    String question = null;
    List<String> maths = new ArrayList<>();
    for (Matcher m = p.matcher(input); m.find(); end = m.end()) {
        if (m.group(1).equals("maths")) {
            maths.add(m.group(2).trim());
        } else {
            if (question != null)
                printQuestionAndMaths(question, maths);
            question = m.group(2);
            maths.clear();
        }
    }
    if (question != null)
        printQuestionAndMaths(question, maths);
    if (end < input.length()) {
        throw new IllegalArgumentException("Unexpected text at offset " + end + ": " +
                         input.substring(end).replaceFirst("(.*\\R.*)(?s:.*)", "$1"));
    }
}

private static void printQuestionAndMaths(String question, List<String> maths) {
    System.out.println("Q: " + question);
    if (! maths.isEmpty())
        System.out.println("M: " + maths.stream().collect(Collectors.joining(" ")));
}