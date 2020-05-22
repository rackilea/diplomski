public class MyBean {
    private Clock clock;  // dependency inject
    ...
    public void process(LocalDate eventDate) {
      if (eventDate.isBefore(LocalDate.now(clock)) {
        ...
      }
    }
  }