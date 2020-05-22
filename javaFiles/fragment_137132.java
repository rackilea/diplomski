String sentence = "<XXX>word1</XXX> word2 word3 <YYY>word4 word5 word6</YYY> word7 word8 word9 word10 <ZZZ>word11 word12</ZZZ>.";
Pattern pattern = Pattern.compile("<(\\w+)[^>]*>.*?</\\1>\\.?|\\S+");
Matcher matcher = pattern.matcher(sentence);

while (matcher.find()) {
    System.out.println(matcher.group());
}