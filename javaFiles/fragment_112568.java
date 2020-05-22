Enumeration<JarEntry> entries=jarFile.entries()

    while(entries.hasMoreElements()) {
       JarEntry entry = entries.nextElement()
       Certificate[] certificates = entry.getCertificates()
       // process certificates in this jar entry
    }