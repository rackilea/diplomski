private static void read(final File folder)  {

    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            read(fileEntry);
        } else {
       //Do something
            }
    }
}