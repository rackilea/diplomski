FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
  .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
  .build();

FirebaseApp.initializeApp(options);