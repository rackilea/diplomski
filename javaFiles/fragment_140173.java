static class StringToRowConverter extends DoFn<String, TableRow> {
    /**
     * In this example, put the whole string into single BigQuery field.
     */
    @Override
    public void processElement(ProcessContext c) {
      c.output(new TableRow().set("string_field", c.element()));
    }
  ...
}