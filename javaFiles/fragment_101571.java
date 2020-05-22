public class ScheduledSMTPAppender extends SMTPAppender {
  private final ThreadFactory tf = r -> {
    Thread t = new Thread(r, "ScheduledSMTPAppender Thread");
    t.setDaemon(true); //make daemon or it will prevent your program to exit
    return t;
  };
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1, tf);
  private final List<ILoggingEvent> events = new ArrayList<> ();

  private int maxMessages = 10;

  public ScheduledSMTPAppender() { super(); }
  public ScheduledSMTPAppender(EventEvaluator<ILoggingEvent> eventEvaluator) { super(eventEvaluator); }

  @Override public void start() {
    super.start();
    scheduler.scheduleAtFixedRate(this::sendEmail, 1, 1, TimeUnit.DAYS);
  }

  @Override protected void sendBuffer(CyclicBuffer<ILoggingEvent> cb, ILoggingEvent lastEventObject) {
    events.add(lastEventObject);
    if (events.size() > maxMessages) sendEmail();
  }

  //needs to be synchronized for thread safety
  private synchronized void sendEmail() {
    try {
      if (events.isEmpty()) return;
      ILoggingEvent lastEvent = events.get(events.size() - 1);
      events.remove(events.size() - 1);
      CyclicBuffer<ILoggingEvent> cb;
      if (events.isEmpty()) {
        cb = new CyclicBuffer<>(1);
      } else {
        cb = new CyclicBuffer<>(events.size());
        for (ILoggingEvent e : events) cb.add(e);
      }
      super.sendBuffer(cb, lastEvent);
      events.clear();
    } catch (Exception e) {
      //Important to have a catch all here or the scheduled task will die
      addError("Error occurred while sending e-mail notification.", e);
    }
  }

  //this allows to make "maxMessages" a parameter of your appender
  public int getMaxMessages() { return maxMessages; }
  public void setMaxMessages(int maxMessages) { this.maxMessages = maxMessages; }
}