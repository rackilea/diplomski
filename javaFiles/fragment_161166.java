public abstract class ServiceProvider implements IServiceProvider {
  private final Map<ServiceType, IService> serviceMap;

  protected ServiceProvider() {
    this.serviceMap = new HashMap<>(0);
  }

  protected void addService(ServiceType serviceType, IService service) {
    serviceMap.put(serviceType, service);
  }

  public IService getService(ServiceType servicetype, PartnerType partnerType) throws ServiceNotImplementedException {
    try {
      return this.serviceMap.get(serviceType);
    } catch (Exception e) {
      throw new ServiceNotImplementedException("Not implemented");
    }
  }
}