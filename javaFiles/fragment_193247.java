@Override
public synchronized List<String> list() {
    if (cache == null) {
        cache = loadCountryList();
    }
    return cache;
}

@Override
public synchronized void invalidateCache() {
    cache = null;
}