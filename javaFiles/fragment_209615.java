class MyMemoryConsoleHandler {
 private Logger rootLogger;
 private MemoryHandler mh;
 private Logger l;
 private int size = 3;
 private int entries = 0;
 public MyMemoryConsoleHandler() {
    this.rootLogger = Logger.getLogger("");
    this.rootLogger.removeHandler(rootLogger.getHandlers()[0]);
    ConsoleHandler ch = new ConsoleHandler();
    this.l = Logger.getLogger("test");
    this.mh = new MemoryHandler(ch,this.size,Level.OFF);
 }

 public synchronized void push() {
    this.mh.push();
    if (this.entries > this.size) {
        this.l.severe("Entries in log discarded !!!");
        this.mh.push();
    }
    this.entries = 0;
 }

 public synchronized void addMessage(String m) {
    this.entries++;
    this.l.severe(m);
 }
}