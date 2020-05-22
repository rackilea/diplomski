private void btnFileCountActionPerformed(java.awt.event.ActionEvent evt) {
    try (SMBClient client = new SMBClient()) {
        try (Connection connection = client.connect(SERVER)) {
            AuthenticationContext ac = new AuthenticationContext(USERNAME, PASSWORD.toCharArray(), WORKGROUP);
            try (Session session = connection.authenticate(ac)) {
                try (DiskShare share = (DiskShare) session.connectShare(SHARE)) {
                    List<String> files = new ArrayList<>();
                    listFiles(share, START_DIR, files);
                    files.removeIf(name -> !name.toLowerCase().endsWith(".mp4"));
                    files.forEach(System.out::println);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace(System.err);
    }
}

private void listFiles(DiskShare share, String path, Collection<String> files) {
    List<String> dirs = new ArrayList<>();
    String extPath = path.isEmpty() ? path : path + "\\";
    for (FileIdBothDirectoryInformation f : share.list(path)) {
        if ((f.getFileAttributes() & FileAttributes.FILE_ATTRIBUTE_DIRECTORY.getValue()) != 0) {
            if (!isSpecialDir(f.getFileName())) {
                dirs.add(f.getFileName());
            }
        } else {
            files.add(extPath + f.getFileName());
        }
    }
    dirs.forEach(dir -> listFiles(share, extPath + dir, files));
}

private static boolean isSpecialDir(String fileName) {
    return fileName.equals(".") || fileName.equals("..");
}