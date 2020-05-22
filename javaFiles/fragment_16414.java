List<String> allMatches = new ArrayList<>();
String pattern = "(?<=reference_word\\s?:\\s?)([a-zA-Z_0-9]+)";
String testString = "XXX...reference_word : word_to_extract ...XXXX ...reference_word: word_to_extract2 ...reference_word :word_to_extract3 scz";

Matcher m = Pattern.compile(pattern).matcher(testString);
while (m.find()) {
  allMatches.add(m.group());
}

System.out.println(allMatches);