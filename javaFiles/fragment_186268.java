void doSomething(File file) {
    // do something with file
}

void processFile(File file) {
    if (file.isDirectory()) {
        for (File sub : file.listFiles()) {
            processFile(sub);
        }
    } else {
        doSomething(file);
    }
}