UserModel model = ...
HashMap<String, Object> map = new HashMap<>();
String userEmail = model.getUserEmail()
if (userEmail != null) {
    map.put("userEmail", userEmail);
}
// etc for other fields...

FirebaseFirestore.getInstance().document(...).set(map);