public class Services {

    private static Map<String, Service> SERVICES = new HashMap<String, Service>();

    static interface Service {
        /** Services with the same name are considered equivalent */
        public String getName();
    }

    public static synchronized void installService(Service service) {
        SERVICES.put(service.getName(), service);
    }

    public static synchronized Service lookup(String name) {
        return SERVICES.get(name);
    }
}