public static long countWordOccurence(String sentence, String word) {
    if(!word.codePoints().allMatch(Character::isLetter))
        throw new IllegalArgumentException(word+" is not a word");
    Pattern p = Pattern.compile("\\b"+word+"\\b", Pattern.CASE_INSENSITIVE);
    int count = 0;
    for(Matcher m = p.matcher(sentence); m.find(); count++) {}
    return count;
}