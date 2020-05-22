Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
      @Override
      public boolean execute() {
        hide(selectedButton);
        return false;
      }
    }, 250);