Assert.assertTrue(
    Pattern.compile(
        PropertyLoader.loadProperty("filename.properties", "Text"),  
        Pattern.MULTILINE
    ).matcher(actual).matches()
);