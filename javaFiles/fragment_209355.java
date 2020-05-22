Enumeration<? extends ZipEntry> entries = apkDetails.entries();
while (entries.hasMoreElements()) {
    ZipEntry entry = entries.nextElement();
    String name = entry.getName();
    if (entry.startsWith("lib/armeabi-v7a/") && entry.endsWith(".so")) {
        // Matching entry found.
    }
}