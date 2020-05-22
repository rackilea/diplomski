public static void main(String[] args) throws IOException {
    // Build a new authorized API client service.
    Drive service = getDriveService();

    // Print the names and IDs for up to 10 files.
    FileList result = service.files().list()
         .setPageSize(10)
         .setFields("nextPageToken, files(id, name)")
         .execute();
    List<File> files = result.getFiles();
    if (files == null || files.size() == 0) {
        System.out.println("No files found.");
    } else {
        System.out.println("Files:");
        for (File file : files) {
            System.out.printf("%s (%s)\n", file.getName(), file.getId());
        }
    }
}