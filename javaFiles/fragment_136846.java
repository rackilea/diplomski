Firestore db = firestoreOptions.getService();
  ApiFuture<QuerySnapshot> query = db.collection("data").get();
  QuerySnapshot querySnapshot = query.get();
  List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
  ArrayList<String> titles = new ArrayList<>();
  for (QueryDocumentSnapshot document : documents) {
    System.out.println("auto id: " + document.getId());
    String title = document.getString("title");
    titles.add(title);
  }
  System.out.println("titles = " + titles);