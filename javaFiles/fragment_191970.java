public class EmptyStackException extends RuntimeException {
      public EmptyStackException() {
          super();
      }
      public EmptyStackException(String s) {
          super(s);
      }
      public EmptyStackException(String s, Throwable throwable) {
          super(s, throwable);
      }
      public EmptyStackException(Throwable throwable) {
          super(throwable);
      }
    }