@SpringBootApplication
@EnableConfigurationProperties({FileProperties.class, TargetProperties.class})
public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        ExcelReader excelReader = applicationContext.getBean(ExcelReader.class);
        try {
            excelReader.openExcel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}