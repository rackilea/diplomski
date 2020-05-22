@After
public void statusCheck() {
    if (status!=TestLinkAPIResults.PASSED) {
        status = TestLinkAPIResults.FAILED;
    }
}