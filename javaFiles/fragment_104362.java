FirebaseOptions options = new FirebaseOptions.Builder()
        .setApiKey("AI...j0")
        .setApplicationId("1:5...e0")
        .setDatabaseUrl("https://myapp.firebaseio.com")
        .build();
FirebaseApp firebaseApp = FirebaseApp.initializeApp(getApplicationContext(), options, "second app");
FirebaseDatabase database = FirebaseDatabase.getInstance(firebaseApp);
database.getReference().setValue(ServerValue.TIMESTAMP);