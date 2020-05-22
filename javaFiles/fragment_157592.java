boolean isDeleted = false;
File f = new File (// Put your file here);
while (!isDeleted) {
    if (f.canWrite()) {
        f.delete();
        isDeleted = true;
    } else {
        try {
            Thread.sleep(10); // Throws Exception you need to catch somewhere...
        } catch (Exception e) {}
    }
}