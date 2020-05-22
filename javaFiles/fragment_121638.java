public static String between(String start, String end, String input) {
    int startIndex = input.indexOf(start);
    int endIndex = input.lastIndexOf(end);
    if(startIndex == -1 || endIndex == -1) return input;
    else return input.substring(startIndex + start.length(), endIndex + end.length()).trim();
}