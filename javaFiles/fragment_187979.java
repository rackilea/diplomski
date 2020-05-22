inputStream.filter(..logic1)
        .to(Serdes.String(), Serdes.String(), "output1");
inputStream.filter(..logic2)
        .to(Serdes.String(), Serdes.String(), "output2");

KafkaStreams streams = new KafkaStreams(builder, /* config */);
streams.start();