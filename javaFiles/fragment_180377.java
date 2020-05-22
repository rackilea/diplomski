Enumeration<JarEntry> jarEntryEnumeration = jarFileArchive.entries();
   while(jarEntryEnumeration.hasMoreElements()){
            jarEntry = jarEntryEnumeration.nextElement();
            if (jarEntry.isDirectory()) {
                //Do something
                }
}