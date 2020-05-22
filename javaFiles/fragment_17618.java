Map<String, Object> favoriteRestaurants = new HashMap<>();
Map<String, Object> restaurant = new HashMap<>();
restaurant.put("restaruantIdOne", true);
favoriteRestaurants.put("favoriteRestaurants", restaurant);
String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
DocumentReference uidRef = rootRef.collection("users").document(uid);
uidRef.update(favoriteRestaurants);