public class TimerExample implements EntryPoint, ClickListener {
  int count = 45;

  public void onModuleLoad() {
    Button b = new Button("Click to start Clock Updating");
    b.addClickListener(this);
    RootPanel.get().add(b);
  }

  public void onClick(Widget sender) {
    // Create a new timer that updates the countdown every second.
    Timer t = new Timer() {
      public void run() {
        countdown.setText(Integer.toString(count));
        count--;
      }
    };

    // Schedule the timer to run once every second, 1000 ms.
    t.schedule(1000);
  }
}