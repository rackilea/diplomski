@Override
protected void onStart() {
    super.onStart();
    notebookRef.addSnapshotListener(MainActivity.this, new EventListener<QuerySnapshot>() {
        @Override
        public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
            if (e != null){
                return;
            }

            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){

                String title = documentSnapshot.get("tvtitle").toString();
                String description = documentSnapshot.get("tvcategory").toString();

                lstBook.add(new book(title,"test",description,R.drawable.themartian));

            }
        }
    });
}