public static class MyObject {
   @XmlMixed
   @XmlAnyElement(lax = true)
   protected List<Object> content;

   public List<Object> getContent() {
      if (content == null) {
          content = new ArrayList<Object>();
      }
      return this.content;
    }
}