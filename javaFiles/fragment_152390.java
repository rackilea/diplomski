public static void main(String[] args) throws IOException {
    String logPath = "/tmp/log";
    String safeFolder = "/tmp/q";
    ArrayList<File> files = new ArrayList<File>();
    BufferedReader br = new BufferedReader(new FileReader(logPath));
    String line = null;


    while ((line = br.readLine()) != null) {
            files.add(new File(line));

            System.out.println("File found:" + files.get(files.size() - 1));
    }

    String root = "/tmp/" ;

    for (File f : files && f.isFile()) {

        if (f.exists()) {
            File destFile = new File(safeFolder, f.getAbsolutePath().replace(root,""));
            destFile.getParentFile().mkdirs();
            if (!f.renameTo(destFile)) {
                System.out.println("Moving file: " + f + " to " + safeFolder);
                System.err.println("Unable to move file: " + f);
            }
       } else {
            System.out.println("Could not find file: " + f);
        }
    }
}