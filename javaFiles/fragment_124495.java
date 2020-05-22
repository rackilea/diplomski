String filename = "non_existing_dir"  + File.separator + "someDir";

File  f = new File(filename);
if (!f.exists()) {
    if (!f.getParentFile().exists()) {
         // make the dir
         f.getParentFile().mkdir();
    }
    f.mkdir();
}