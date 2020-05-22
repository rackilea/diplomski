try (final ChronicleQueue queue = SingleChronicleQueueBuilder.binary("temp-dir-2").build()) {
  final ExcerptAppender appender = queue.acquireAppender();
  try (DocumentContext dc = appender.writingDocument()) {
    dc.wire().write("hello").text("world");
  }
  DumpQueueMain.dump("temp-dir-2");
}