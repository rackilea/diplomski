String folderId = "folderID";
File fileMetadata = new File();
fileMetadata.setName("Invoices");
fileMetadata.setParents(Collections.singletonList(folderId));
fileMetadata.setMimeType("application/vnd.google-apps.folder");

File file = driveService.files().create(fileMetadata)
.setFields("id, parent")
.execute();
System.out.println("Folder ID: " + file.getId());