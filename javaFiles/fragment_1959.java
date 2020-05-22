File fileMetadata = new File();
fileMetadata.setName(fileTitle);

// setting the id of folder to which the file must be inserted to
fileMetadata.setParents(Collections.singletonList("dumbTeamDriveId"));
fileMetadata.setMimeType("application/pdf");

// decoding base64 to PDF and its contents to a byte array without saving the file on the file system
byte[] pdfBytes = Base64.getDecoder().decode(base64File.getBytes(StandardCharsets.UTF_8);
InputStream inputStream = new ByteArrayInputStream(pdfBytes);
InputStreamContent mediaContent = new InputStreamContent("application/pdf", inputStream);

try {
  // upload updated agreement as a PDF file to the Team Drive folder
  DriveUtils.getDriveService().files().create(fileMetadata, mediaContent)
                            .setSupportsTeamDrives(true) // remember to set this property to true!
                            .execute();
} catch (IOException ex) {
  logger.error("Exception: {}", ex.getMessage());
  throw new IOException("Exception: " + ex.getMessage());
} catch (GeneralSecurityException ex) {
  logger.error("Exception: {}", ex.getMessage());
  throw new GeneralSecurityException("Exception: " + ex.getMessage());
}