@Test(dataProvider = "objectCodes", dataProviderClass = ExampleDataProvider.class)
     public void test(String ShapeCode, String ColorCode) throws IOException {
           .............
           /* tests for color shape combination */
           .............
          }

@Test(dataProvider = "ShapeCodes", dataProviderClass = ExampleDataProvider.class)
    public void test(String ShapeCode) throws IOException {
        .............
        /* tests for  shapes */
        .............
    }

@Test(dataProvider = "ColorCodes", dataProviderClass = ExampleDataProvider.class)
    public void test(String ColorCode) throws IOException {
        .............
        /* tests for colors */
        .............
    }