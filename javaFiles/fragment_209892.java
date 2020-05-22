private boolean unpack(File zipFile, File targetDir) {
    ZipFile zip = null;
    try {
        zip = new ZipFile(zipFile.getAbsoluteFile());
        final Enumeration<ZipArchiveEntry> entries = zip.getEntries();
        while(entries.hasMoreElements()) {
            ZipArchiveEntry entry = entries.nextElement();
            if (entry.isDirectory()) {
                mkdirsOrThrow(new File(targetDir, entry.getName()));
                continue;
            }
            final File entryDestination = new File(targetDir,  entry.getName());
            mkdirsOrThrow(entryDestination.getParentFile());
            final InputStream in = zip.getInputStream(entry);
            final OutputStream out = new FileOutputStream(entryDestination);
            IOUtils.copy(in, out);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    } finally {
        if (zip!= null) try {
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return true;
}