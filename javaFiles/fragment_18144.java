private Map<String, Service> serviceMap; // modified in MapTest

static class Service {
  private String id, name;

  public Service(String id, String name) {
    this.id = id;
    this.name = name;
  }
}

MapTest services = new MapTest();
services.setService("ID01", new Service("ID01", "Jack"));
services.setService("ID02", new Service("ID02", "Neil"));

stream.addImplicitMap(MapTest.class, "serviceMap", "s", Service.class, "id");