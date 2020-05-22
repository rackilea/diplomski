@Test
  void testApplicationXML_FIXED() {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/app-config.xml");
    CommonService commonService = context.getBean("service", CommonService.class);
    assertEquals("Overridden: Message: Hello!", commonService.service());
  }