String fileName = fi.getName();// name provided by uploader
if (fileName == null || fileName == "") {
    resumefilepath = "";
} else {
    // convert to simple name, i.e. remove any prepended path
    fileName = fileName.substring(fileName.lastIndexOf(File.separatorChar)+1);
    // your substitution:
    if(fileName.equalsIgnoreCase("A.png")) fileName="B.png";
    // construct File object
    file = new File(resumePath, fileName);
    // and create/write the file
    fi.write(file);
}