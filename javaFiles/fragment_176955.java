String parentFolderPath = "parentFolder";
String fileName = "file.txt";
File parent = new File(parentFolderPath);
for (File subFolder : parent.listFiles()) {
    if (subFolder.isDirectory()) {
        File f = new File(subFolder, fileName);
        if (f.exists()) {
            // your code here
        }
    }
}