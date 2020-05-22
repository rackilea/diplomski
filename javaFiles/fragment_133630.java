File txt1 = new File("txt1");
File txt2 = new File("txt2");
long lastmodified = txt1.lastModified();
while(true) {
    if (txt1.lastModified()>lastModified) {
        // Read from txt2
        // Increment value or initialize to 0;
        // Write new value to txt2;
        lastModified = txt2.lastModified();
    }
    try {
        Thread.sleep(1000);
    } catch(InterruptedException e) {
    }
}