public void loadModelWithDataFromFirebase(){
    Firebase db = new Firebase(//url);
    Firebase bookmarksRef = fb.child(//access correct child);

    Log.v("Async101", "Start loading bookmarks");
    final ArrayList<Bookmark> loadedBookmarks = new ArrayList<Bookmark>();
    bookmarksRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Log.v("Async101", "Done loading bookmarks");
            //getting all properties from firebase...
            Bookmark bookmark = new Bookmark(//properties here);
            loadedBookmarks.add(bookmark);
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) { }
    });
    Log.v("Async101", "Returning loaded bookmarks");
    setBookmarks(loadedBookmarks);
}