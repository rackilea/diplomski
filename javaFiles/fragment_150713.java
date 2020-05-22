@Test
public void verifyKeywordTest() {

// Beginning of code here

List<String> keywordsChunks = getChuncks(KEYWORDS);
keywordsChunks.forEach(chunk -> {
    VerifyKeyword verifyKeyword = new VerifyKeyword(getWebDriver(), LOCK, chunk);
    verifyKeyword.start();

// Rest of the code here