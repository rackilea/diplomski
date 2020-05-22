Scheduler.get().scheduleFinally(new ScheduledCommand() {
   @Override
   public void execute() {
      _app.goTo(new LoginPlace(_app.getCurrentPlaceToken());
   }
}