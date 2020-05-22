@Bean
public FirebaseApp provideFirebaseOptions() throws IOException {
    log.info("INIT FIRBASE");
    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(apiKey.getInputStream()))
            .setStorageBucket(bucketPath)
            .build();
    return FirebaseApp.initializeApp(options);
}
// add this bean to provide StorageOptions service
@Bean
public Storage provideStorageService() throws IOException {
    log.info("INIT STORAGE");
    return StorageOptions.newBuilder()
            .setCredentials(ImplFirebaseTrampolines.getCredentials(provideFirebaseOptions()))
            .build()
            .getService();
}