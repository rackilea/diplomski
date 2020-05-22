public void streamData() {

        try {
            Pipeline pipeline = Pipeline.create(options);

            pipeline.apply("Read PubSub Events", PubsubIO.readMessagesWithAttributes().fromSubscription(options.getInputSubscription()))
            .apply(options.getWindowDuration() + " Window",
                    Window.<PubsubMessage>into(FixedWindows.of(parseDuration(options.getWindowDuration())))
                          .triggering(AfterWatermark.pastEndOfWindow()) 
                          .discardingFiredPanes()
                          .withAllowedLateness(parseDuration("24h")))
            .apply(FileIO.<String,PubsubMessage>writeDynamic()
                    .by(new datePartition(options.getOutputFilenamePrefix()))
                    .via(Contextful.fn(
                            (SerializableFunction<PubsubMessage, String>) inputMsg -> new String(inputMsg.getPayload(), StandardCharsets.UTF_8)),
                            TextIO.sink())
                    .withDestinationCoder(StringUtf8Coder.of())
                    .to(options.getOutputDirectory())
                    .withNaming(type -> new CrowdStrikeFileNaming(type))
                    .withNumShards(options.getNumShards())
                    .withTempDirectory(options.getTempLocation()));

            pipeline.run();
        }

        catch(Exception e) {

            LOG.error("Unable to deploy pipeline");
            LOG.error(e.toString(), e);
        }

    }