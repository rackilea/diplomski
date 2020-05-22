@SpringBootApplication
public class LogApplication {

   private static final Logger logger = Logger.getLogger(LogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }

    @Controller
    @ResponseBody
    public static class IndexController{

        @RequestMapping("/")
        public String getindex(){
            logger.error("Error Logging");
            return "Hello";
        }
    }
}