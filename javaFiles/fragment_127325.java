...
FileWriter fw = new FileWriter(file, true);
for (File f : javaFile) {
    FileReader fr = new FileReader(f);
    // read 1000 chars at a time from source file
    char[] cbuf = new char[1000];
    int count = -1;
    // iterate till the end of source file
    // here count represent the no of chars read at a time
    while ((count = fr.read(cbuf)) != -1) {
        // write in the targeted file
        fw.write(cbuf, 0, count);
    }
    fr.close();
}
...