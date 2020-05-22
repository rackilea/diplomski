File fileMetadata = new File();
fileMetadata.setName("My Report");
fileMetadata.setMimeType("application/vnd.google-apps.spreadsheet");

java.io.File filePath = new java.io.File("files/report.csv");
FileContent mediaContent = new FileContent("text/csv", filePath);
File file = driveService.files().create(fileMetadata, mediaContent)
        .setFields("id")
        .execute();
System.out.println("File ID: " + file.getId());