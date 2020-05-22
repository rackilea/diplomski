FirestorePagingOptions<User> firestorePagingOptions = new FirestorePagingOptions.Builder<User>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<User>() {
                    @NonNull
                    @Override
                    public User parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        User user = snapshot.toObject(User.class);
                        user.userId = snapshot.getId();
                        return user;
                    }
                })
                .build();