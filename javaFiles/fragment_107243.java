RealmQuery<User> query = realm.where(User.class);

// Add query conditions:
query.equalTo("name", "John");

// Execute the query:
RealmResults<User> result1 = query.findAll();