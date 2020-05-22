@Override                                                                                                                   
public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {  
   if(queryDocumentSnapshots == null){
       return;
   }
   for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges())