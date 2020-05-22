@Override
public boolean onQueryTextSubmit(String query) {
   ArrayList<Note> notes = Utilities.getAllSavedNotes(getApplicationContext());
   final NoteListAdapter na = new NoteListAdapter(this, R.layout.list_component, notes);
   na.getFilter().filter(query);
   return false;
}