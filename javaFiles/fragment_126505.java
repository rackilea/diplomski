@Test
    public void myTest() throws Exception{
        String assertionError = null;
        try {
            Assert.assertEquals(2,3);
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
        }
        System.out.println(assertionError);

    }