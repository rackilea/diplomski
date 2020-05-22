parser.getRecordMetadata().setTypeOfColumns(Short.class, "age" /*, and other column names*/);

//to get 0 instead of nulls when the field is empty in the file:
parser.getRecordMetadata().setDefaultValueOfColumns("0", "age", /*, and other column names*/);

// then parse
for (Record record : parser.iterateRecords(is)) {
    Map<String,Object> map = record.toFieldMap();
}