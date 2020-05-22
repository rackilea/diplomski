try {
    FileInputStream serviceAccount =
            new FileInputStream("firebaseKey/serviceAccountKey.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://xxxxx.firebaseio.com")
            .build();
    FirebaseApp fireApp = FirebaseApp.initializeApp(options);

    StorageClient storageClient = StorageClient.getInstance(fireApp);
    InputStream testFile = new FileInputStream(file.getPath());
    String blobString = "NEW_FOLDER/" + "FILE_NAME.jpg";
    Blob blob = storageClient.bucket("xxxxxx.appspot.com")
                    .create(blobString, testFile , Bucket.BlobWriteOption.userProject("xxxxxxx"));
    blob.getStorage().createAcl(blob.getBlobId(), Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
    System.out.println(blob.getMediaLink());
} catch (Exception e){
    e.printStackTrace();
}