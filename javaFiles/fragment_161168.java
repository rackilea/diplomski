@Service("serviceStrategy")
public class ServiceStrategy implements IServiceStrategy {

  @Resource(name = "serviceProviderPartnerA")
  IServiceProvider serviceProviderPartnerA;

  @Resource(name = "serviceProviderPartnerB")
  IServiceProvider serviceProviderPartnerB;

  @Resource(name = "serviceProviderPartnerC")
  IServiceProvider serviceProviderPartnerC;

  public IService getService(ServiceType serviceType, PartnerType partnerType) throws PartnerNotImplementedException {
    switch (partnerType) {
      case PARTNER_A:
        return serviceProviderPartnerA.getService(serviceType, partnerType);
      case PARTNER_B:
        return serviceProviderPartnerB.getService(serviceType, partnerType);
      case PARTNER_C:
        return serviceProviderPartnerC.getService(serviceType, partnerType);
      default:
        throw new PartnerNotImplementedException();
    }
  }
}