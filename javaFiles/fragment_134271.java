final DataType myAvroType = SchemaConverters.toSqlType(MyAvroRecord.getClassSchema()).dataType();

final Function1<GenericRecord, Row> myAvroRecordConverter =
        MySchemaConversions.createConverterToSQL(MyAvroRecord.getClassSchema(), myAvroType);

Row[] convertAvroRecordsToRows(List<GenericRecord> records) {
    return records.stream().map(myAvroRecordConverter::apply).toArray(Row[]::new);
}