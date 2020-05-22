@Service("serviceProviderPartnerA")
public class ServiceProviderPartnerA extends ServiceProvider {

  @Resource(name = "partnerASearchService")
  private ISearchService partnerASearchService;

  @Resource(name = "partnerABookingService")
  private IBookingService partnerABookingService;

  @PostConstruct
  public void init() {
    super.addService(ServiceType.SEARCH, partnerASearchService);
    super.addService(ServiceType.BOOKING, partnerABookingService);
  }
}