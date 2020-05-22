@Test(expected = ParseException.class)
@Parameters(
    "[[]",
    "[]]",
    "[] hi",
    "hi",
    "[h]i",
    "[hi []",
    "[[]]"
)
public void invalidListFromatShouldFail(String input) {        
    ListUtil.parseList(toTest, TestEnum.class);
}