class Person {
   private Map<String,Object> attrs = new HashMap<>();

   public void setAttribute(String attr, Object value)
   {
      attrs.put(attr,vaue);
   }

   public Object getAttribute(String attr)
   {
      attrs.get(attr);
   }

}

Person person = new Person();
person.setAttribute("firstname","patrick");
String firstname = (String)person.getAttribute("firstname");