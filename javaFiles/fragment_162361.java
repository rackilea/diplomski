public void print(final Object ob) {
    Runnable run = new Runnable() {
        @Override
        public void run() {
            CMD_HISTORY.append(ob.toString());
        }
    };
    if (EventQueue.isDispatchThread()) {
        run.run();
    } else {
        EventQueue.invokeLater(run);
    }
}

public void println(Object ob) {
    Runnable run = new Runnable() {
        @Override
        public void run() {
            CMD_HISTORY.append(ob.toString() + "\n");
        }
    };
    if (EventQueue.isDispatchThread()) {
        run.run();
    } else {
        EventQueue.invokeLater(run);
    }
}