File parent = filelist[i].getParentFile();

String newName = filelist[i].getName().substring(4);
if (!filelist[i].renameTo(new File(parent, newName)) {
    System.out.println("FAILED");
}