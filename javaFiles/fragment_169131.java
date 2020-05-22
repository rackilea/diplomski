List<String> mainList = new ArrayList<>();  //The one to contain all Strings from yourList
List<String> yourList = Arrays.asList("Hey", "how", "are", "you");    //The list of Strings

StringJoiner joiner = new StringJoiner(" "); //Space as delimiter, strings will be separated with spaces
for (String s : yourlist) {
    joiner.add(s);
}
mainList.add(joiner.toString());    //Add the new concatenated String to your list, in a single string