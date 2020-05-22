public class MockHttpSession implements HttpSession {
  Map<String, Object> map = new HashMap<>();

  @Override
  public Object getAttribute(String name) {
    return map.get(name);
  }

  @Override
  public void setAttribute(String name, Object value) {
    map.put(name, value);
  }


  // implement rest of the methods you will use