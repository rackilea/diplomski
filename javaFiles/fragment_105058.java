class A implements Runnable {

    private final ExecutionStrategy strategy;

    public A(int var) {   
        strategy = new FooStrategy();
    }

    public A(int var1, String var2) {
        strategy = new BarStrategy();
    }

    public void run() {
        strategy.exec();
    }

    interface ExecutionStrategy { 
        public void exec();
    }

    private class FooStrategy implements ExecutionStrategy { 
        @Override
        public void exec() { 
        //implement me
        }
    }

    private class BarStrategy implements ExecutionStrategy { 
        @Override
        public void exec() { 
        //implement me
        }
    }
}