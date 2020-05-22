public class MyClass {
   private String title;
   private String content;
   private String link;
   public static class Builder {
      private String title;
      private String content;
      private String link;

      public void setTitle(String title) { this.title = title; }
      public void setContent(String content) { this.content = content; }
      public void setLink(String link) { this.link = link; }
      public MyClass build() {
         return new MyClass(this);
      }
   }

   private MyClass(Builder builder) {
      // Validate here.
      if (builder.title == null)
         throw new IllegalArgumentException("Title is required!");
      this.title = builder.title;
      this.content = builder.content;
      this.link = builder.link;
   }
}