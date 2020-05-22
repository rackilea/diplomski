public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml")) {
            ConversionService service = context.getBean(ConversionService.class);
            System.out.println(service);
        }
}