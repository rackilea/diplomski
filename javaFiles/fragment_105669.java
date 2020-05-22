@Inject
public RecordValidationHelper(
    @Named("json") IRecordValidationService jsonValidation,
    @Named("avro") IRecordValidationService avroValidation,
    @Named("clientlogging") IRecordValidationService clientLoggingValidation,
    @Named("servicelogs") IRecordValidationService serviceLogsValidation,
  ) {
    this.jsonValidation = jsonValidation;
    this.avroValidation = avroValidation;
    this.clientLoggingValidation = clientLoggingValidation;
    this.serviceLogsValidation = serviceLogsValidation;
}