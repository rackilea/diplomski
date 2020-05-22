public void storeNotes( String Id, String Title ,String Location) {

    realm.beginTransaction();
    NotesRealmClass Notes = new NotesRealmClass();
    Notes.setobjectId(Id);
    Notes.setLocation(Location);
    Notes.setTitle(Title);
    if (realm.where(NotesRealmClass.class).equalTo("objectId", Id).count() == 0) {
        // there are no object with this `Id`
        realm.copyToRealmOrUpdate(Notes);
    } 
    Toast.makeText(context, "Notes Stored", Toast.LENGTH_SHORT).show();
    realm.commitTransaction();

}