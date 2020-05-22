new ByteBuddy()
  .redefine(SampleClass.class)
  .visit(Advice.to(TimerAdviceStart.class).on(named("startMethod"))
  .visit(Advice.to(TimerAdviceEnd.class).on(named("endMethod"))
  .defineField("foo", long.class, Visibility.PRIVATE)
  .make();