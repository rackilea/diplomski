getlistofbrands
  .collection(FireStoreConstants.COL_BRANDNAMESONLY)
  .document("Brands")
  .get()
  .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                Map<String, String> brandsMap = (Map<String, String>)documen.getData().getData("AllBrands");
                List<String> brands = new LinkedList<String>();

                for (String key: brandsMap.keySet()) {
                    brands.add(brandsMap.get(key));
                }

                // TODO: use the brands list
            } else {
                Log.d(TAG, "No such document");
            }
        } else {
            Log.d(TAG, "get failed with ", task.getException());
        }
    }
  });