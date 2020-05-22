db.collectionGroup("Id").whereEqualTo("id" , UserId).get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        city = document.getString("city");
                    }
                }
                userCity = city;
                setUpRecyclerView()
            }

        });