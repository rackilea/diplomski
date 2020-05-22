// Bad: User user = api.getUser();

// Good 
api.getUser(new OnUserResult() {
    @Override public void onUser(User u) {
         // Update the UI, or whatever 
        // Do not assign a global user variable here either 
    } 
});
// any external user variable will (usually) still be null here