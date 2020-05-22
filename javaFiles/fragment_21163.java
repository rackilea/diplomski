Query firebaseSearchQuery = mDatabaseReference
    .child("mov")
    .child("bolly")
    .child("new")
    .orderByChild("name_mov")
    .equalTo(s);