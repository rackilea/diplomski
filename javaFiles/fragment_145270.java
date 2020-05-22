// first obtain the base path where you are running your code
URL url = getClass().getClassLoader().getResource(".");

// then check for the existence of the file you need
File f = new File(url.getPath() + entry.getName());

// check for the flag to overwrite the file or it doesn't exist
if(!file.exists() || overwrite) {

    copyInputStream(zipFile.getInputStream(entry),
               new BufferedOutputStream(new FileOutputStream(entry.getName())));

}