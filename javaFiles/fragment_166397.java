try {
  URL u = new URL("http://www.java2s.com");
  Object o = u.getContent();
  System.out.println("I got a " + o.getClass().getName());
} catch (Exception ex) {
  System.err.println(ex);
}