public static String unZip(String path) throws IOException {
    int count = -1;

    File sourceFile = new File(path);
    String name = sourceFile.getName();
    name = name.substring(0, name.lastIndexOf(".zip"));
    File sourcePath = new File(sourceFile.getParent(), name);

    System.out.println("SavePath = " + sourcePath);
    if (!sourcePath.exists() && !sourcePath.mkdirs()) {
        throw new IOException("Could not create directory " + sourcePath);
    }
    String topLevelDirName = "";
    try (ZipFile zipFile = new ZipFile(sourceFile)) {
        Enumeration<?> entries = zipFile.entries();
        int levelCount = 0;
        byte buf[] = new byte[1024];
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String filename = entry.getName();
            File file = new File(sourcePath, filename);
            if (entry.isDirectory()) { //If it is a directory
                levelCount++;
                System.out.println("Make directory " + file);
                if (!file.exists() && !file.mkdirs()) {
                    throw new IOException("Could not create directory " + filename);
                }
            } else {
                System.out.println("Extract to " + file);
                try (InputStream is = zipFile.getInputStream(entry);
                                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
                    while ((count = is.read(buf)) > -1) {
                        bos.write(buf, 0, count);
                    }
                }
            }
        }
    }
    return topLevelDirName;
}