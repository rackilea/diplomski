FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference phonesRef = rootRef.collection("Phones");
phonesRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Items items = document.toObject(Items.class);

                String name1 = items.getName();
                String company1 = items.getCompany();
                String image1 = items.getImage();

                name.setText(name1);
                company.setText(company1);
                Picasso.get()
                        .load(image1)
                        .fit()
                        .centerCrop()
                        .into(imageView);
            }
        }
    }
});