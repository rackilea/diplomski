public class SearchClasses {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        printAllFileWithMethod("println");
    }

    public static void printAllFileWithMethod(String methodName) throws FileNotFoundException, IOException {
        Enumeration<URL> roots = SearchClasses.class.getClassLoader().getResources("");

        List<File> allClassFiles = new ArrayList<>();
        while (roots.hasMoreElements()) {
            File root = new File(roots.nextElement().getPath());
            allClassFiles.addAll(getFilesInDirectoryWithSuffix(root, "class"));
        }

        for (File classFile : allClassFiles) {
            InputStream is = new FileInputStream(classFile);

            boolean found = false;
            Scanner scanner = new Scanner(is);
            while (scanner.hasNext()) {
                if (scanner.nextLine().contains(methodName)) {
                    System.out.print(methodName + " found in " + classFile.getName() + "\n");
                    found = true;
                    break;
                }
            }

        }
    }

    public static void testMethod() {
        System.out.println("testing");
    }

    static List<File> getFilesInDirectoryWithSuffix(File dir, String suffix) {
        List<File> foundFiles = new ArrayList<>();
        if (!dir.isDirectory()) {
            return foundFiles;
        }
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                foundFiles.addAll(getFilesInDirectoryWithSuffix(file, suffix));
            } else {
                String name = file.getName();
                if (name.endsWith(suffix)) {
                    foundFiles.add(file);
                }
            }

        }
        return foundFiles;
    }

}