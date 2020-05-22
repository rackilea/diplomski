public final class MyTest {
   @NotNull
   public TestSubject subject;

   @NotNull
   public final TestSubject getSubject() {
      TestSubject var10000 = this.subject;
      if(this.subject == null) {
         Intrinsics.throwUninitializedPropertyAccessException("subject");
      }
      return var10000;
   }

   public final void setSubject(@NotNull TestSubject var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.subject = var1;
   }
}