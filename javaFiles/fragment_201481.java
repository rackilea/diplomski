for(Provider p : Security.getProviders()) {
    System.out.println("Provider " + p.getName());
    for(Map.Entry e : p.entrySet()) {
        System.out.println("    " + e.getKey() + " : " + e.getValue());
    }
}