@SpringBootApplication
@EnableConfigurationProperties(TestSpringBootApplication.MyProperties.class)
public class TestSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner cmd(MyProperties props) {
        return args -> {
            System.out.println("myMap: " + props.getMyMap());
            System.out.println("justmap: " + props.getJustmap());
        };
    }

    @ConfigurationProperties(prefix = "my.app")   
    static class MyProperties {
        private Map<String, String> myMap;
        private Map<String, String> justmap;

        public Map<String, String> getMyMap() {
            return myMap;
        }
        public void setMyMap(Map<String, String> myMap) {
            this.myMap = myMap;
        }
        public Map<String, String> getJustmap() {
            return justmap;
        }
        public void setJustmap(Map<String, String> justmap) {
            this.justmap = justmap;
        }

    }

}