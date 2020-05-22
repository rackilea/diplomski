public static List<File> displayDirectoryContents(File dir) {
    ArrayList<File> rtnFiles = new ArrayList<File>();

    try {
            File[] files = dir.listFiles();

            for (File file : files) {

                    if (file.isDirectory()) {
                            rtnFiles.addAll(displayDirectoryContents(file));

                    } else {
                        if (file.getName().endsWith((".pdf"))) {
                            System.out.println("     file:" + file.getCanonicalPath());
                            rtnFiles.add(file);
                        }
                    }
            }
    } catch (IOException e) {
            e.printStackTrace();
    }

    return rtnFiles;
}