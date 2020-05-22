class Delegator {

    @Autowired
    private List<MyService> services;

    public MyService findService(String action) {
        for (MyService service : services) {
            if (service.canHandle(action) ) {
                return service
            }
        }
        throw new IllegalArgumentException("Could not find service to handle: "+action);
    }

}