// Here I create a metadata using ONLY the database fields
IRowsetMetaData metadata = new RowsetMetaData();
Fields fields =  clientDoc.getDataDefController().getDataDefinition().getResultFields();
Fields dbFields = new Fields();
for (int i = 0; i < fields.size(); i++) {
    IField field = fields.getField(i);
    if (field instanceof DBField) {
        dbFields.add(field);
    }
}
metadata.setDataFields(dbFields);

// Create the rowset cursor with metadata
RowsetCursor cursor = clientDoc.getRowsetController().createCursor(null, metadata);
FetchedRecordCountInfo countInfo = new FetchedRecordCountInfo();
countInfo.setIsTotalRecordsKnown(false);

// Here, if I don't have any record from my stored procedure, I don't execute the report process
int nbRecords = cursor.getRecordCount(countInfo);
if (nbRecords <= 0) {
    throw new ReportingException("UnmanagedJob - Report generation : No data, generation aborted.");
}