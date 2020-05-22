public void myAssertTrue(Boolean condition){
    try {
        Assert.assertTrue(condition);
    } catch (AssertionError e) {
        e.printStackTrace();
        throw new RuntimeException();
    }
}