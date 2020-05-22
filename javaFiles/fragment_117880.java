File f1 = new File("c:\test\aaa\temp.txt"); 
File f2 = new File("d:\test\aaa\temp.txt");

if (!f1.exists()) {
    // throw an exception
}

// Copy the file as is, retain attributes, replace existing
CopyOption[] options = new CopyOption[] {COPY_ATTRIBUTES, REPLACE_EXISTING};
if (f2.exists()) {
    if ((f1.lastModified() != f2.lastModified()) || (f1.length() != f2.length()) {
        Files.copy(f1, f2, options);
    }
} else {
    Files.copy(f1, f2, options);
}