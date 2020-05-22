@Configuration
public class EndPointTestConfiguration {

    @Value("${billing.engine.address}")
    private String mockServerIP;
    @Value("${billing.engine.port}")
    private String mockServerPort;

    @Bean
    public String mockAddress() {
        String mockServerAddress = "http://" + mockServerIP + ":" + mockServerPort;
        return mockServerAddress;

    }



    @Bean
    public GetVersionEndPoint getVersionEndPoint() {
        return new GetVersionEndPoint();
    }

    @Bean
    public AnalyzeEndPoint analyzeEndPoint() throws JAXBException {
        return new AnalyzeEndPoint();
    }

    @Bean
    public PredictionEngineService predictionEngineService() {
        return new PredictionEngineService();
    }

    @Bean
    public String studyDetailDemo() throws IOException {
        File file = ResourceUtils.getFile("src/test/resources/study-details-demo.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        return content;
    }

    @Bean
    public String studyDetailSampleNormal() throws IOException {
        File file = ResourceUtils.getFile("src/test/resources/study-details-normal.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        return content;
    }

    @Bean
    public String studyDetailSampleCms() throws IOException {
        File file = ResourceUtils.getFile("src/test/resources/study-details-cms.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        return content;
    }

}