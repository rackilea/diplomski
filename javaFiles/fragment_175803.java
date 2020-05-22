public class SessionMap {

  private static Map<ServletContext, Set<HttpSession>> map =
    new HashMap<ServletContext, Set<HttpSession>>();

  private SessionMap() {
  }

  public static Map<ServletContext, Set<HttpSession>> getInstance() {
    return map;
  }

  public static void invalidate(String[] contexts) {
    synchronized (map) {
      List<String> l = Arrays.asList(contexts);     
      for (Map.Entry<ServletContext, Set<HttpSession>> e : map.entrySet()) {
        // context name without the leading slash
        String c = e.getKey().getContextPath().substring(1);
        if (l.contains(c)) {
          for (HttpSession s : e.getValue()) 
            s.invalidate();
        }
      }
    }
  }

}