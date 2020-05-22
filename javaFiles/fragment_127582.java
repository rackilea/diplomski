@Override
public boolean onQueryTextChanged(String query) {
   if (!query.equals("")) {
      ArrayList<Note> notes = Utilities.getAllSavedNotes(getApplicationContext());
      final NoteListAdapter na = new NoteListAdapter(this, R.layout.list_component, notes);
      na.getFilter().filter(query);
   } else {
      ArrayList<Note> notes = Utilities.getAllSavedNotes(getApplicationContext());
      final NoteListAdapter na = new NoteListAdapter(this, R.layout.list_component, notes);
   }
   return false;
}