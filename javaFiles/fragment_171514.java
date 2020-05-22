File file = new File("/home/aa.db");
File dir = new File("dir");

if (file.renameTo(new File(dir, file.getName()))) {
    // processing here
}