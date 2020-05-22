try (ZipInputStream in = new ZipInputStream(new FileInputStream("foobar.epub"))) {
    for (ZipEntry entry = in.getNextEntry(); entry != null; 
        entry = in.getNextEntry()) {
        System.out.printf("%td.%<tm.%<tY %<tH:%<tM:%<tS %9d %s\n",
                new Date(entry.getTime()), entry.getSize(), entry.getName());
        if (entry.getName().endsWith("logo.jpg")) {
            try (FileOutputStream out = new FileOutputStream(entry.getName())) {
                // process the file
            }
        }
    }
}