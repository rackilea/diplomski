public static void main(String[] args)
{
    String source = "c:/File";
    String target = "c:/Target";

    // get the files in the source directory and sort it
    File sourceDir = new File(source);
    File[] files = sourceDir.listFiles();
    Arrays.sort(files, new Comparator<File>() {
        public int compare(File f1, File f2) {
            return (int) (f1.lastModified() - f2.lastModified());
        }
    });

    // create the target directory
    File targetDir = new File(target);
    targetDir.mkdirs();

    // copy the files
    for(int i=0, length=Math.min(files.length, 10); i<length; i++)
        files[i].renameTo(new File(targetDir, files[i].getName()));
}