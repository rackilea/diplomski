public void synchronizeBookmarks(){
    Firebase db = new Firebase(//url);
    Firebase bookmarksRef = fb.child(//access correct child);

    final ArrayList<Bookmark> loadedBookmarks = new ArrayList<Bookmark>();
    bookmarksRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Bookmark bookmark = new Bookmark(//properties here);
            loadedBookmarks.add(bookmark);
            setBookmarks(loadedBookmarks);
            loadSampleData();
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) { throw firebaseError.toException(); }
    });
}