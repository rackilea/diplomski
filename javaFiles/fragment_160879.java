interface IWorkState {
    //Declares the method of WorkState
}

class WorkState implements IWorkState {
    //Whatever java bean
}

class WorkTask implements Runnable {
    private final IWorkState state;

    public void addStateObserver(IWorkState initialState) {
         state = initialState
    }

    @Override
    public void run() {
        //Task instructions here
        //instructions should operate on the state variable
    }
}

class VarMonitor {
    public void update(Object changed) {
        //subject has changed, react to it
        eventQueue.submit(/* a Runnable that handles the state change,
                           with embedded information about the change */);

    }
}

class MainClass {
    public static void main(String[] args) {
        final VarMonitor mon = new VarMonitor();
        WorkTask t = new WorkTask(Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {IWorkState.class}, new InvocationHandler() {
            private final WorkState realWorkState = new WorkState();
            Object invoke(Object proxy, Method method, Object[] args) {
                Object res = method.invoke(realWorkState, args);
                //An annotation would work better
                if (method.getName().substring(0,3).equals("set")) {
                    mon.update(this);
                }
            }
        });
    }
}