private final static String getCharacter(final String character) {
    // the following characters are in the correct (i.e. Unicode) order
    final String initials = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ";// list of initials
    final String vowels = "ᅡᅢᅣᅤᅥᅦᅧᅨᅩᅪᅫᅬᅭᅮᅯᅰᅱᅲᅳᅴᅵ";// list of vowels
    final String finals = "ᆨᆩᆪᆫᆬᆭᆮᆯᆰᆱᆲᆳᆴᆵᆶᆷᆸᆹᆺᆻᆼᆽᆾᆿᇀᇁᇂ";// list of tail characters
    final int characterValue = character.codePointAt(0); // Unicode value
    final int hangulUnicodeStartValue = 44032;
    if (characterValue < hangulUnicodeStartValue)
        return character; // for instance for 32 (space)

    final int tailIndex = Math.round((characterValue - hangulUnicodeStartValue) % 28) - 1;
    final int vowelIndex = Math.round(((characterValue - hangulUnicodeStartValue - tailIndex) % 588) / 28);
    final int initialIndex = (characterValue - hangulUnicodeStartValue) / 588;
    final String leadString = initials.substring(initialIndex, initialIndex + 1);
    final String vowelString = vowels.substring(vowelIndex, vowelIndex + 1);
    final String tailString = tailIndex == -1 ? "" : finals.substring(tailIndex, tailIndex + 1);// may be -1 when there is no tail character
    return leadString + vowelString + tailString;
}