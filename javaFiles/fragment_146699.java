if(fileToLook != null) {
    if(fileToLook.isDirectory()) {
        for(File f:fileToLook.listFiles())
            deepSearch(f,fileStorage,mod);
    } else {
        fileStorage.add(fileToLook);
        mod.addElement(fileToLook.getName());
    }
} else {
    System.out.println("Reached an end."); // not sure if you really need this
                                           // statement. It looks like a debug print to me
}