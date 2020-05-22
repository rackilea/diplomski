/**
 * We'll use this pattern as divider to split the string into an array.
 * Usage: myString.split(DIVIDER_PATTERN);
 */
private static final String DIVIDER_PATTERN =

        "(?<=[^\\p{Lu}])(?=\\p{Lu})"
                // either there is anything that is not an uppercase character
                // followed by an uppercase character

                + "|(?<=[\\p{Ll}])(?=\\d)"
        // or there is a lowercase character followed by a digit

        ;

@Test
public void testStringSplitting() {
    assertEquals(2, "3/4Word".split(DIVIDER_PATTERN).length);
    assertEquals(7, "ManyManyWordsInThisBigThing".split(DIVIDER_PATTERN).length);
    assertEquals(7, "This123/4Mixed567ThingIsDifficult"
                        .split(DIVIDER_PATTERN).length);
}