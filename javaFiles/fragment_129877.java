public void storeNotes( String Id, String Title ,String Location) {
    try {
        realm.beginTransaction();
        NotesRealmClass Notes = new NotesRealmClass();
        Notes.setobjectId(Id);
        Notes.setLocation(Location);
        Notes.setTitle(Title);
        realm.copyToRealm(Notes); // <======
        Toast.makeText(context, "Notes Stored", Toast.LENGTH_SHORT).show();
        realm.commitTransaction();
    } catch (Exception error) {
        realm.cancelTransaction();
    }
}