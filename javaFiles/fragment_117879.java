File f1 = new File("c:\test\aaa\temp.txt"); 
File f2 = new File("d:\test\aaa\temp.txt");

// Same modify date?
if ((f1.lastModified() != f2.lastModified()) || (f1.length() != f2.length())) {
    // add to copy list
}