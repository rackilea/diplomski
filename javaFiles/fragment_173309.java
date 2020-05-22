private Map<String, Supplier<Resource>> resourceSuppliers;

public TheClass() {
    resourceSuppliers = new HashMap<>();
    resourceSuppliers.put("A", Utils::getResourceA);
    resourceSuppliers.put("B", Utils::getResourceB);
    resourceSuppliers.put("C", Utils::getResourceC);
    ...
}

private Resource getResource(String type){
    return resourceSuppliers.get(type).get();
}