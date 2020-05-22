class CustomParseException extends Exception {
   int line;
   int column;

   public CustomParseException(String msg, int l, int c) {
     super(msg);
     line = l;
     column = c;
   }
 }

 CustomParseException e = catchThrowableOfType(
                            () -> { throw new CustomParseException("boom!", 1, 5); }, 
                            CustomParseException.class);
 // assertions succeed
 assertThat(e).hasMessageContaining("boom");
 assertThat(e.line).isEqualTo(1);
 assertThat(e.column).isEqualTo(5);