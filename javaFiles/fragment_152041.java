@Component
public class ApiMultiplexingProcessor extends TMultiplexedProcessor {

    UserServiceHandler userServiceHandler;
    ReportServiceHandler reportServiceHandler;
    // ... more service handlers can go here

    @Autowired
    public ApiMultiplexingProcessor(UserServiceProcessor userServiceProcessor, ReportServiceProcessor reportServiceProcessor) {
        this.registerProcessor("UserService", userServiceProcessor);
        this.registerProcessor("ReportService", reportServiceProcessor);
        // add more registerProcessor lines here for additional services

        userServiceHandler = userServiceProcessor.getHandler();
        reportServiceHandler = reportServiceProcessor.getHandler();
        // set any additional service handlers here
    }

    // getters and setters for the handlers

    public UserServiceHandler getUserServiceHandler() {
        return userServiceHandler;
    }

    public void setUserServiceHandler(UserServiceHandler userServiceHandler) {
        this.userServiceHandler = userServiceHandler;
    }

    public ReportServiceHandler getReportServiceHandler() {
        return reportServiceHandler;
    }

    public void setReportServiceHandler(ReportServiceHandler reportServiceHandler) {
        this.reportServiceHandler = reportServiceHandler;
    }
}