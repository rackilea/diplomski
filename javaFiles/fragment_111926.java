FirebaseFirestore.getInstance()
.collection(collectionReferencePath)
.get().addOnSuccessListener { querySnapshots ->
  querySnapshots.documents.forEach { documentSnapshot ->
      val idUnique = documentSnapshot.id //This is the Unique Id

  }
}.addOnFailureListener {
  it.printStackTrace()
}