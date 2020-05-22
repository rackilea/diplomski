holder.like.setOnClickListener(view -> {
            if (holder.like.getTag().equals("like")) {
                FirebaseDatabase.getInstance().getReference().child("Likes").child(post.getPostid()).runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        mutableData.child(firebaseUser.getUid()).setValue(true);
                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                        if (dataSnapshot != null) // No error has occurred
                            if (dataSnapshot.hasChild(firebaseUser.getUid())) // Data is present at the location databaseReferenceLikes
                                if (b) { // Transaction was successfully completed
                                    addNotification(post.getPublisher(), post.getPostid());
                                }

                        if (databaseError != null)
                            databaseError.toException().printStackTrace();
                    }
                });
            } else {
                FirebaseDatabase.getInstance().getReference().child("Likes").child(post.getPostid()).runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        mutableData.child(firebaseUser.getUid()).setValue(null);
                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                        if (dataSnapshot != null) // No error has occurred
                            if (!dataSnapshot.hasChild(firebaseUser.getUid())) // Confirm that data is removed from location databaseReferenceLikes
                                if (b) // Transaction was successfully completed
                                    removeNotification(post.getPublisher(), post.getPostid());

                        if (databaseError != null)
                            databaseError.toException().printStackTrace();
                    }
                });
            }
        });