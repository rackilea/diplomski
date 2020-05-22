byte[] buffer = new byte[4096];
try (SevenZFile sevenZFile = new SevenZFile(fc)) {
    for (SevenZArchiveEntry entry : sevenZFile.getEntries()) {
        try (FileOutputStream out = new FileOutputStream(_location + entry.getName())) {
            for (int len; (len = sevenZFile.read(buffer)) > 0; ) {
                out.write(buffer, 0, len);
            }
        }
    }
}