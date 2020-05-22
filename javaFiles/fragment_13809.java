@Test
    public void readXmlToSelfDefinedPojo2() throws Exception {

        ObjectMapper mapper = new XmlMapper();
        Schedule pojo = mapper.readValue(
                        Thread.currentThread().getContextClassLoader().getResourceAsStream("48963966.xml"),
                        Schedule.class);
        System.out.println(pojo + "");
    }