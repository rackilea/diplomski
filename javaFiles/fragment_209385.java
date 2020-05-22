if (StringUtil.isWhitespace(c)) {
    charType = CharacterEnum.WHITESPACE;
} else if (Character.isLetter(c) || c=='#') {
    charType = CharacterEnum.ALPHABETIC;
} else if (Character.isDigit(c)) {
    charType = CharacterEnum.NUMERIC;
} else {
    charType = CharacterEnum.OTHER;
}