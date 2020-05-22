interface VarArgsRunnable {
     default void run(Object ... arguments) {
          throw new UnsupportedOperationException("not possible");
     }
     default int getNumberOfArguments() {
          throw new UnsupportedOperationException("unknown");
     }
}