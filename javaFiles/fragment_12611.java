FirebaseOptions options = new FirebaseOptions.Builder()
  .setServiceAccount(new FileInputStream("path/to/serviceAccountKey.json"))
  .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
  .build();

FirebaseApp.initializeApp(options);