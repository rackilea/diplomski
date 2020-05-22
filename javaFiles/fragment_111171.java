querySearch = FirebaseFirestore.getInstance()
               .collection("App").document(" " + userID).collection("reminders")
               .startAt("title", newText)
               .endAt("title", newText+"\uf8ff"); 


FirestoreRecyclerOptions<ModelClass.class> options = new FirestoreRecyclerOptions.Builder<ModelClass.class>()
    .setQuery(querySearch, ModelClass.class)
    .build();