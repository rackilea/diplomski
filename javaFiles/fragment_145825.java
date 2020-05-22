//TestDebugMeGrammar.java

    private static DebugEventListener newEventListener() {
        return (DebugEventListener) Proxy.newProxyInstance(TestDebugMeGrammar.class.getClassLoader(),
                new Class[] { DebugEventListener.class },
                new DebugListenerHandler());
    }

    public static class DebugListenerHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            // simply print out the method call.
            System.out.print(method.getName());

            if (args != null && args.length > 0) {
                System.out.print(": ");
                for (int i = 0, count = args.length; i < count; ++i) {
                    Object arg = args[i];
                    if (arg == null) {
                        System.out.printf("<(null)> ");
                    } else {
                        System.out.printf("<%s> ", arg.toString());
                    }
                }
            }

            System.out.println();
            return null;
        }
    }