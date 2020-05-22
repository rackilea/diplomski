public void newNoteAction(View view){
    ndb.addNote(new NoteItem("Title", "Contents"));
    // don't do this
    // you are creating a new adapter and not binding it back to listview
    // a = ndb.getAllNotes(); 
    // mAdapter = new ArrayAdapter<NoteItem>(this, android.R.layout.simple_list_item_1, a);
    mAdapter.add(new NoteItem("Title", "Contents"));
    mAdapter.notifyDataSetChanged();
    System.out.println(ndb.getAllNotes().size());
}