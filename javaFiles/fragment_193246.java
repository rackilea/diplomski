@Override
public List<String> list() {
    if (cache == null) {
        cache = loadCountryList();
    }
    return cache;
}

@Override
public void invalidateCache() {
    cache = null;
}