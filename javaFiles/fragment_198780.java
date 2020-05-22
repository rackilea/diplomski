private static class DelegatingCookieManager extends CookieManager {
    @Override public void setCookiePolicy(CookiePolicy cookiePolicy) {
        delegate.get().setCookiePolicy(cookiePolicy);
    }

    @Override public CookieStore getCookieStore() {
        return delegate.get().getCookieStore();
    }

    @Override public Map<String, List<String>> get(
            URI uri, Map<String, List<String>> requestHeaders)
            throws IOException {
        return delegate.get().get(uri, requestHeaders);
    }

    @Override public void put(URI uri, Map<String,
            List<String>> responseHeaders)
            throws IOException {
        delegate.get().put(uri, responseHeaders);
    }
}