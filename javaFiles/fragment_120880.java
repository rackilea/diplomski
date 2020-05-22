public static void main(String[] args) throws IOException {
    // Build a new authorized API client service.
    Drive service = getDriveService();
    try {
        // Print the file path and name.
        FileList result = service.files().list().execute();
        List<File> files = result.getItems();

        if (files == null || files.size() == 0) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");

            for (File file : files) {
                if (!(file.getMimeType().contains("folder"))) {
                    String filePath = null;

                    if (!(file.getParents().isEmpty())) {
                        filePath = getFilePath(service, file);
                    }

                    System.out.println("path: " + filePath);
                    System.out.println("name: " + file.getTitle());
                    System.out.println();
                }
            }
            System.out.println("== END ==");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

private static String getFilePath(Drive drive, File file) throws IOException {
    String folderPath = "";
    String fullFilePath = null;

    List<ParentReference> parentReferencesList = file.getParents();
    List<String> folderList = new ArrayList<String>();

    List<String> finalFolderList = getfoldersList(drive, parentReferencesList, folderList);
    Collections.reverse(finalFolderList);

    for (String folder : finalFolderList) {
        folderPath += "/" + folder;
    }

    fullFilePath = folderPath + "/" + file.getTitle();

    return fullFilePath;
}

private static List<String> getfoldersList(Drive drive, List<ParentReference> parentReferencesList, List<String> folderList) throws IOException {
    for (int i = 0; i < parentReferencesList.size(); i++) {
        String id = parentReferencesList.get(i).getId();

        File file = drive.files().get(id).execute();
        folderList.add(file.getTitle());

        if (!(file.getParents().isEmpty())) {
            List<ParentReference> parentReferenceslist2 = file.getParents();
            getfoldersList(drive, parentReferenceslist2, folderList);
        }
    }
    return folderList;
}