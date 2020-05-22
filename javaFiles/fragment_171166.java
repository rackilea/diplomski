public class HealthStatusImpl implements HealthStatus {

    private RestTemplateService restTemplateService;

    // favor constructor injection
    public HealthStatusImpl(RestTemplateService restTemplateService){
        this.restTemplateService = restTemplateService;
    }

    @Override
    public Integer healthCheck() {
        Integer status = 0;
        try {
            ResponseEntity<String> healthResponse = restTemplateService.getForHealthCheck();
            status = healthResponse.getStatusCode().is2xxSuccessful() ? 200 : 400;
        } catch (Throwable th) {
            th.printStackTrace();
        }

        return status;
    }
}