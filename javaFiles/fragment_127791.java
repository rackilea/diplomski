@FunctionalInterface
interface VarArgsRunnable4 extends VarArgsRunnable {
     @Override
     default void run(Object ... arguments) {
          assert(arguments.length == 4);
          run(arguments[0], arguments[1], arguments[2], arguments[3]);
     }

     void run(Object arg0, Object arg1, Object arg2, Object arg3, Object arg4);

     @Override
     default int getNumberOfArguments() {
          return 4;
     }
}