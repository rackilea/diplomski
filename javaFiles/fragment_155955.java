when(cursor.hasNext()).thenAnswer(new Answer() {
   private int count = 0;

   public Object answer(InvocationOnMock invocation) {
        return (count++ < 250);
   }
});