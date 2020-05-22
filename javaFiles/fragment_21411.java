//connect to AR server
ARServerUser server = new ARServerUser();
server.setServer("localhost");
server.setUser("Demo");
server.setPassword("");
// begin bulk transaction
server.beginBulkEntryTransaction();
//create and submit Entry Objects

for(int x = 0; x < 10; x++){
  try {
        Entry entry = new Entry();
        entry.put(Constants.AR_CORE_SUBMITTER, new Value(submitter));
        entry.put(Constants.AR_CORE_STATUS,new Value(status, DataType.ENUM));
        entry.put(Constants.AR_CORE_SHORT_DESCRIPTION, new Value(shortDesc));
        entryIdOut = server.createEntry(formName, entry);
    } catch (ARException e) {
        ARExceptionHandler(e, "Cannot create the entry." );
    }
}
//Commit Bulk transaction: all entries are saved to Remedy
 List<BulkEntryReturn>  bulkIds = server.endBulkEntryTransaction(Constants.AR_BULK_ENTRY_ACTION_SEND);
 //bulkIds now contains all the entry Ids for your committed entries