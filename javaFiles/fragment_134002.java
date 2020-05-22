public enum Subject
{
   SEND_VERIFY(new SendVerifySubjectProcessor()),
   do_foo2(new Foo2SubjectProcessor()),
   ...
   private SubjectProcessor processor

   Subject(SubjectProcessor processor) {
     this.processor = processor;
   }

   public void process(JSONObject data) {
     this.processor.process(data);
   }
}