void validateSchema(JsonNode schemaNode) throws JsonProcessingException {

  SyntaxValidator validator = JsonSchemaFactory.byDefault().getSyntaxValidator();

  ProcessingReport report = new ListProcessingReport(null, LogLevel.INFO);
  ValueHolder<SchemaTree> holder = ValueHolder.<SchemaTree>hold("schema",
      new CanonicalSchemaTree(SchemaKey.anonymousKey(), schemaNode));

  Processor<ValueHolder<SchemaTree>, ValueHolder<SchemaTree>> processor =
    validator.getProcessor();
  report = ProcessingResult.uncheckedResult(processor, report, holder).getReport();

  if (!report.isSuccess()) {
    IllegalArgumentException ex = new IllegalArgumentException();

    for (ProcessingMessage processingMessage : report) {
      ex.addSuppressed(processingMessage.asException());
    }

    throw ex;
  }
}