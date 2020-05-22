Provider[] provs = Security.getProviders();
for (Provider prov : provs) {
    Set<Service> services = prov.getServices();
    for (Service service : services) {
        if (!service.getType().matches("(?i)Cipher")) {
            break;
        }
        String algo = service.getAlgorithm();
        if (algo.matches("(?i).*/GCM/.*")) {
            System.out.println(service);
        }
    }
}