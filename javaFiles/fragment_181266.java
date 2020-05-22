public class JarResourcesUtils {

    public static File extractFileFromJar(String path) throws IOException {
        String resourcePath = JarResourcesUtils.class.getResource(path).getPath();
        String jarPath = resourcePath.replace("!" + path, "").replace("file:", "");

        try (JarFile jarFile  = new JarFile(jarPath)){
            Enumeration<JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()) {
              JarEntry entry = entries.nextElement();
              String entryName = "/" + entry.getName();
              if (entryName.equals(path)) {
                  InputStream inputStream = jarFile.getInputStream(entry);
                  File file = File.createTempFile(entryName.replaceAll("//", "_"), ".tmp");
                  FileUtils.copyToFile(inputStream, file);
                  return file;
              }
           }
           return null;
         }
     }
}