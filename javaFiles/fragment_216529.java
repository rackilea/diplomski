private static HashMap<String, Long> sizesForDirectory(String directory, boolean recurseInSubDirectories) {
    File folder = new File(directory);
    File[] listOfFiles = folder.listFiles();

    HashMap<String, Long> sizesByExtension = new HashMap<String, Long>();
    if (listOfFiles != null) {
        for (File file : listOfFiles) {
            if (!file.isDirectory()) {
                String extension = file.getName().replaceAll(".*\\.", "");
                if (sizesByExtension.containsKey(extension)) {
                    Long size = sizesByExtension.get(extension) + Long.valueOf(file.length());
                    sizesByExtension.put(extension, size);
                } else {
                    sizesByExtension.put(extension, file.length());
                }
            } else if (recurseInSubDirectories) {
                HashMap<String, Long> sizesForSubdirectory = sizesForDirectory(file.getAbsolutePath(), recurseInSubDirectories);
                for (String ext : sizesForSubdirectory.keySet()) {
                    if (sizesByExtension.containsKey(ext)) {
                        sizesByExtension.put(ext, sizesByExtension.get(ext) + sizesForSubdirectory.get(ext));
                    } else {
                        sizesByExtension.put(ext, sizesForSubdirectory.get(ext));
                    }
                }
            }
        }
    }

    return sizesByExtension;
}

public static void main(String[] args) {

    HashMap<String, Long> sizesByExtension = sizesForDirectory("your/path", true);

    for (String ext : sizesByExtension.keySet()) {
        System.out.println(ext + " : " + sizesByExtension.get(ext));
    }

}