@Component
class DefaultMglsAdapter implements MglsAdapter {
    // fields to hold the configs
    DefaultMglsAdapter(@Value("${mgls.server.address}") String address,
                                   @Value("${mgls.fname}") String  fname,
                                   @Value("${mgls.lcount}") long lcount) {
        // set fields
    }
    @PreDestroy
    void close() {
        // cleanup
    }
}