public Integer findAddressId(String name) {
    return getPersons(name).stream()
        .flatMap(person -> findAddresses(person).stream()
            .filter(address -> livesAtAddress(person, address)))
        .findFirst()
        .map(address -> address.getId())
        .orElseThrow(() -> new RuntimeException("Cannot find address for person " + name));
}