FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if (user != null) {
    // Name, getEmail or etc
    String name = user.getDisplayName();   

    Log.d("TAG" + name) // the name ...
}