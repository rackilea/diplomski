protected HashSet<ProxyListPlace> getTopPlaces() {
    Set<Class<? extends EntityProxy>> types = ApplicationEntityTypesProcessor.getAll();
    HashSet<ProxyListPlace> rtn = new HashSet<ProxyListPlace>(types.size());

    for (Class<? extends EntityProxy> type : types) {
        rtn.add(new ProxyListPlace(type));
    }

    return rtn;
}