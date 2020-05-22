Set<String> startedServices = new HashSet<String>();

for ( String service: Services ) {
    boolean allClear = true;
    for ( String predecessor: Service(service).getPredecessors() ) {
        if ( ! startedServices.contains(predecessor) ) {
            allClear = false;
            break;
        }
    }
    if ( allClear ) {
        // start the service
        new Thread(new Service(service, 1000, Start, Stop, Services)).start();
        startedServices.add(service);
    }
}