// in your scheduled @Component
@Autowired
private SomeDataDAO someDataDAO;

@Scheduled(cron = "...")
public void fetchThirdPartyData() {

    SomeData thirdPartyData = getThirdPartyData();
    someDataDAO.save(thirdPartyData);
}

private SomeData getThirdPartyData() {
    // calling their API...
}