Map<String, String> entries = new HashMap<String, String>();
entries.put("firstContent", "1.txt");
entries.put("secondContent", "2.txt");
entries.put("thirdContent", "3.txt");

FileOutputStream fos = null;
ZipOutputStream zos = null;
try {
    fos = new FileOutputStream("output.zip");

    zos = new ZipOutputStream(fos);

    for (Map.Entry<String, String> mapEntry : entries.entrySet()) {
        ZipEntry entry = new ZipEntry(mapEntry.getValue()); // create a new zip file entry with name, e.g. "1.txt"
        entry.setMethod(ZipEntry.DEFLATED); // set the compression method
        zos.putNextEntry(entry); // add the ZipEntry to the ZipOutputStream
        zos.write(mapEntry.getKey().getBytes()); // write the ZipEntry content
    }
} catch (FileNotFoundException e) {
    // do something
} catch (IOException e) {
    // do something
} finally {
    if (zos != null) {
        zos.close();
    }
}