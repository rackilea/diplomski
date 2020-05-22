PCollection<ModifiedThing> modifiedThings = things.apply(
    ParDo.of(new DoFn<Thing, ModifiedThing>() {
  public void processElement(ProcessContext c) {
    for (int i = 0; i < 2000; ++i) {
      c.output(modify(c.element()));
    }
  }
}));