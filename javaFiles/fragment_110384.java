public class BeamPipeline {
    private static final Logger log = LoggerFactory.getLogger(BeamPipeline.class);
    public static interface MyOptions extends PipelineOptions {

        @Description("Input Path(with gs:// prefix)")
        String getInput();
        void setInput(String value);
    }

    public static void main(String[] args) {

        MyOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(MyOptions.class);
        Pipeline p = Pipeline.create(options);
        File dir = new File(options.getInput());
        for (File file : dir.listFiles()) {
                String inputString = file.toString();
                p
                        .apply("Match Files", FileIO.match().filepattern(inputString))
                        .apply("Read Files", FileIO.readMatches())
                        .apply(MapElements.via(new SimpleFunction<FileIO.ReadableFile, KV<String, String>>() {
                            public KV<String, String> apply(FileIO.ReadableFile file) {
                                String temp = null;
                                try {
                                    temp = file.readFullyAsUTF8String();
                                } catch (IOException e) {

                                }
                                String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(temp);

                                JsonObject obj = new JsonObject();
                                obj.addProperty(temp, sha256hex);
                                String json = obj.toString();

                                try (FileWriter fileWriter = new FileWriter("./manifest.json")) {
                                    fileWriter.write(json);
                                } catch (IOException e) {

                                }

                                return KV.of(file.getMetadata().resourceId().toString(), sha256hex);

                            }
                        }))
                        .apply("Print", ParDo.of(new DoFn<KV<String, String>, Void>() {
                            @ProcessElement
                            public void processElement(ProcessContext c) {


                                log.info(String.format("File: %s, SHA-256 %s", c.element().getKey(), c.element().getValue()));

                            }
                        }));
                }
            p.run();
        }
}