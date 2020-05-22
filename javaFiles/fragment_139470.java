public static void deleteFile(File directory, String fileName) {

    if (directory.isDirectory()) {
        for(File file : directory.listFiles()) {

            if (file.getName().contains(fileName)) {

                if (file.isFile()) {
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }
    }
}