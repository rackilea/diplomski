Enumeration<InputStream> streams = Collections.enumeration(
    Arrays.asList(new InputStream[] {
        new ByteArrayInputStream("<root>".getBytes()),
        yourXmlLikeStream,
        new ByteArrayInputStream("</root>".getBytes()),
    }));

SequenceInputStream seqStream = new SequenceInputStream(streams);

// Now pass the `seqStream` into the SAX parser.