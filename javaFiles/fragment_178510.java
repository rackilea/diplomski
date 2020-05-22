public static long countWordOccurence(String sentence, String word) {
    if(!word.codePoints().allMatch(Character::isLetter))
        throw new IllegalArgumentException(word+" is not a word");
    Pattern p = Pattern.compile("\\b"+word+"\\b");
    return p.matcher(sentence).results().count();
}