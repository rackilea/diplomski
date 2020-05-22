FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference usersRef = rootRef.collection("User-Info");
usersRef.orderBy("User_Slug", Query.Direction.ASCENDING)
    .startAt(queryText)
    .endAt(queryText + "\uf8ff")
    .limit(1)
    .get();