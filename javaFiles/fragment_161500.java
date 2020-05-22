File fileMetadata = new File();
fileMetadata.setName("config.json");
fileMetadata.setParents(Collections.singletonList("appDataFolder"));
java.io.File filePath = new java.io.File("files/config.json");
FileContent mediaContent = new FileContent("application/json", filePath);
File file = driveService.files().create(fileMetadata, mediaContent)
    .setFields("id")
    .execute();