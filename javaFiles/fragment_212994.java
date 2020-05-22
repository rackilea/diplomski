/**
     * Hello world!
     *
     */
    @SpringBootApplication
    @PropertySource(value = { "application.properties","domainapplication.properties" })
    public class App 
    {
        @Autowired
        private ModuleService moduleService;
        public static void main(String[] args) throws Exception {
            ApplicationContext applicationContext= SpringApplication.run(App.class, args);
            ModuleService moduleService = (ModuleService) applicationContext.getBean(ModuleService.class);
            System.out.println(moduleService.getProp());
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        }
    }