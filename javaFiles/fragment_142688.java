public class MyCookieHandler extends CookieHandler {
  private final Map<String, List<String>> cookies = 
                                            new HashMap<String, List<String>>();

  @Override public Map<String, List<String>> get(URI uri,
      Map<String, List<String>> requestHeaders) throws IOException {
    Map<String, List<String>> ret = new HashMap<String, List<String>>();
    synchronized (cookies) {
      List<String> store = cookies.get(uri.getHost());
      if (store != null) {
        store = Collections.unmodifiableList(store);
        ret.put("Cookie", store);
      }
    }
    return Collections.unmodifiableMap(ret);
  }

  @Override public void put(URI uri, Map<String, List<String>> responseHeaders)
      throws IOException {
    List<String> newCookies = responseHeaders.get("Set-Cookie");
    if (newCookies != null) {
      synchronized (cookies) {
        List<String> store = cookies.get(uri.getHost());
        if (store == null) {
          store = new ArrayList<String>();
          cookies.put(uri.getHost(), store);
        }
        store.addAll(newCookies);
      }
    }
  }
}