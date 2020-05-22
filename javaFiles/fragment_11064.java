SyncChunkFilter filter = new SyncChunkFilter();
filter.setIncludeNotes(true);
NoteStoreClient noteStoreClient = clientFactory.createNoteStoreClient();
SyncChunk syncChunk = noteStoreClient.getFilteredSyncChunk(0, 200, filter);

while (true) {
     List<Note> noteListforCurrentChunk = syncChunk.getNotes();
     //Sync to DB
     syncChunk = noteStoreClient.getFilteredSyncChunk(syncChunk.getChunkHighUSN(), 200, filter);
     if (syncChunk.getChunkHighUSN() == syncChunk.getUpdateCount()) {
       return;
     }
}