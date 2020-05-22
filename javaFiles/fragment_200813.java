public class ExamplePipeline {

public static void main(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().create();
    options.setRunner(DirectRunner.class);

    Pipeline pipeline = Pipeline.create(options);

    PCollection<String> linesForPipelineOne = pipeline.apply(Create.of("A1", "B1"));
    PCollection<String> linesToWriteFromPipelineOne = linesForPipelineOne.apply("Pipeline 1 transform",
            ParDo.of(new DoFn<String, String>() {

        @ProcessElement
        public void processElement(ProcessContext c) {
            System.out.println("Pipeline one:" + c.element());
            c.output(c.element() + " extra message.");
        }

    }));
    linesToWriteFromPipelineOne.apply((TextIO.write().to("file.txt")));

    PCollection<String> linesForPipelineTwo = pipeline.apply(Create.of("A2", "B2"));
    linesForPipelineTwo.apply("Pipeline 2 transoform",
            ParDo.of(new DoFn<String, String>() {

        @ProcessElement
        public void processElement(ProcessContext c) {
            System.out.println("Pipeline two:" + c.element());
        }

    }));

    pipeline.run();
}