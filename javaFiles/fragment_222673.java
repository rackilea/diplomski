class WorkerThread {
    public enum Action { DO_STUFF, MAKE_WIDGETS, FROB_BARS }
    private Action action;

    public WorkerThread(Action action) {
        this.action = action;
    }

    public void run (){
        switch (action) {
            case DO_STUFF:     doStuff();     break;
            case MAKE_WIDGETS: makeWidgets(); break;
            case FROB_BARS:    frobBars();    break;
        }
    }

    public void doStuff()     { ... }
    public void makeWidgets() { ... }
    public void frobBars()    { ... }
}