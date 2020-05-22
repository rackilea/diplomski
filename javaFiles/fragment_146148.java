@Override
public void onAddClick(int position) {
    final FoodInfo selectedItem = mfoodinfo.get(position);
    final String selectedKey = selectedItem.getFoodname();

    StorageReference imageRef = firebaseStorage.getReferenceFromUrl(selectedItem.getImageUrl());
    imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
        @Override
        public void onSuccess(Void aVoid) {

            final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Order");
            databaseReference.child(selectedKey).setValue(selectedItem);
            Toast.makeText(Menu.this, "Order Successful!!", Toast.LENGTH_SHORT).show();
        }
    });

}