public enum Subject
{
   SEND_VERIFY(data -> {
     String foo1 = data.getString("foo1_1");
     String foo2 = data.getString("foo1_2");
     ...
   }),

   ...
   private Consumer<Subject> processor

   Subject(Consumer<Subject> processor) {
     this.processor = processor;
   }

   public void process(JSONObject data) {
     this.processor.accept(data);
   }
}