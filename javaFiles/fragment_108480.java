class MyAssert {

    public static void assertLinesEqual(String expectedString, String actualString){
        BufferedReader expectedLinesReader = new BufferedReader(new StringReader(expectedString));
        BufferedReader actualLinesReader = new BufferedReader(new StringReader(actualString));

        try {
            int lineNumber = 0;

            String actualLine;
            while((actualLine = actualLinesReader.readLine()) != null){
                String expectedLine = expectedLinesReader.readLine();
                Assert.assertEquals("Line " + lineNumber, expectedLine, actualLine);
                lineNumber++;
            }

            if(expectedLinesReader.readLine() != null){
                Assert.fail("Actual string does not contain all expected lines");
            }
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        } finally {
            try {
                expectedLinesReader.close();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
            try {
                actualLinesReader.close();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
    }
}