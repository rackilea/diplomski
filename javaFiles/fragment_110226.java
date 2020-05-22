public List<String> getFileNamesInJarPath(String jarPath) {
        List<String> fileNames = new ArrayList<>();
        CodeSource src = MainClass.class.getProtectionDomain().getCodeSource();
        try {
            if (src != null) {
                URL jar = src.getLocation();
                ZipInputStream zip = new ZipInputStream(jar.openStream());
                while (true) {
                    ZipEntry e = zip.getNextEntry();
                    if (e == null)
                        break;
                    String name = e.getName();
                    if (name.startsWith(jarPath)) {
                        String substringedName = name.substring(name.lastIndexOf("/") + 1);
                        if (!substringedName.equalsIgnoreCase("")) {
                            fileNames.add(substringedName);
                        }
                    }
                }
            } else {
                /* Fail... */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNames;
}