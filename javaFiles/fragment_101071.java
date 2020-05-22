ref.createUser(email, pass, new Firebase.ValueResultHandler<Map<String, Object>>() {
     @Override
     public void onSuccess(Map<String, Object> result) {
         System.out.println("Successfully created user account with uid: " + result.get("uid"));


        // read data ...

        // save user data
        Map<String, String> map = new HashMap<String, String>();
        map.put("provider", authData.getProvider());
        map.put("genre", genre);
        map.put("birthDate", birthDate);
        map.put("name", name);

        ref.child("users").child(result.get("uid")).setValue(map);
     }

     @Override
     public void onError(FirebaseError firebaseError) {
         // there was an error
     }
});