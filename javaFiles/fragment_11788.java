File dir = getCacheDir();
//do stuff, saving the file in this directory

FileInputStream fis = null;
try {
    fis = new FileInputStream(new File(dir, "iwastedhalfhouronthis.ser"));
} catch (FileNotFoundException ex) {
}