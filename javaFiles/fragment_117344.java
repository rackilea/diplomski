@Test
    public void testCaseInsensitiveBooleanConversion() {
        CsvParserSettings parserSettings = new CsvParserSettings();
        BeanListProcessor<AB> beanProcessor = new BeanListProcessor<>(AB.class);
        parserSettings.setHeaderExtractionEnabled(false);
        parserSettings.setProcessor(beanProcessor);
        final String[] headers = {"name","age"};
        parserSettings.setHeaders(headers);

        final CsvParser parser = new CsvParser(parserSettings);
        parser.parseLine("dave,21");
        parser.parseLine("jan,23");
        parser.parseLine("eddy,25");

        List<AB> beans = beanProcessor.getBeans();

        Assert.assertEquals("dave", beans.get(0).name);
        Assert.assertEquals(Integer.valueOf(21), beans.get(0).age);

        Assert.assertEquals("jan", beans.get(1).name);
        Assert.assertEquals(Integer.valueOf(23), beans.get(1).age);

        Assert.assertEquals("eddy", beans.get(2).name);
        Assert.assertEquals(Integer.valueOf(25), beans.get(2).age);
    }