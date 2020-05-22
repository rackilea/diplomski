@Configuration
public class MySpringBootConfigFile {
    /*.....  the rest of config */

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean(name = "reportFileA")
    public ReportFile reportFileA() {
        ReportFile reportFile = new ReportFile();
        Resource ressource = resourceLoader.getResource("classpath:documents/report01.rptdesign");
        try {
            reportFile.setResource(ressource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reportFile;
    }      

    /* ...... */
}