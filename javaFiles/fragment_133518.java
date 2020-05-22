@Test
public void deconstructKoreanCharacters() {
    final String koreanText = "항성은 항상 혼자 있는 것이 아니라, 두 개 이상의";
    for (int i = 0; i < koreanText.length(); i++) {
        final String character = koreanText.substring(i, i + 1);
        final String decomposedCharacters = getCharacter(character);
        System.out.println(character + ":" + decomposedCharacters);
    }
    Statics.doNothing();
}