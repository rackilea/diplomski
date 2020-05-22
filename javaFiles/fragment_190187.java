static void renameDuplicates(String fileName, String[] newName) {
    int i=1;
    File file = new File(fileName + "(1).txt");
    while (file.exists() && !file.isDirectory()) {
        file.renameTo(new File(newName[i-1] + ".txt"));
        i++;
        file = new File(fileName + "(" + i + ").txt");
    }
}