@Service
public class ReportService {
    @Value("${mws.appVersion}")
    private String appVersion;

    /* Other initialization and public API methods*/
    @Autowired
    private ReportProcessor reportProcessor;

    @Scheduled(cron = "*/10 * * * * *")
    public void processReport() {
        //InventoryReportProcessor reportProcessor = new InventoryReportProcessor();
        Map<String, Long> skus = reportProcessor.process(new ByteArrayOutputStream());
    }
}