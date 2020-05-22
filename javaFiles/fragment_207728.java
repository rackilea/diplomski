public class RemoveCSVHeader {
  // The Filter class
  static class FilterCSVHeaderFn extends DoFn<String, String> {
    String headerFilter;

    public FilterCSVHeaderFn(String headerFilter) {
      this.headerFilter = headerFilter;
    }

    @ProcessElement
    public void processElement(ProcessContext c) {
      String row = c.element();
      // Filter out elements that match the header
      if (!row.equals(this.headerFilter)) {
        c.output(row);
      }
    }
  }

  // The main class
  public static void main(String[] args) throws IOException {
    PipelineOptions options = PipelineOptionsFactory.create();
    Pipeline p = Pipeline.create(options);

    PCollection<String> vals = p.apply(TextIO.read().from("gs://BUCKET/FILE.csv"));

    String header = "col1,col2,col3,col4";

    vals.apply(ParDo.of(new FilterCSVHeaderFn(header)))
        .apply(TextIO.write().to("out"));

    p.run().waitUntilFinish();
  }
}