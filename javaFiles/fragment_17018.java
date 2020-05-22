public void loadModelWithDataFromFirebase() throws InterruptedException {
    Firebase db = new Firebase(//url);
    Firebase bookmarksRef = fb.child(//access correct child);

    Semaphore semaphore = new Semaphore(0);

    final ArrayList<Bookmark> loadedBookmarks = new ArrayList<Bookmark>();
    bookmarksRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Bookmark bookmark = new Bookmark(//properties here);
            loadedBookmarks.add(bookmark);
            semaphore.release();
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) { throw firebaseError.toException(); }
    });
    semaphore.acquire();
    setBookmarks(loadedBookmarks);
}