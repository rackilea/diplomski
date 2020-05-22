class FileBody {
    public void writeHeaderToEmptyFile(File file) throws IOException {
        if (!FileUtils.isEmpty(file)) return
        try (Writer w = new FileWriter(file)) {
            w.write(getHeader());
        }
    }
}

class enum FileUtils {
    /* no instances */ ;

    // TODO replace all callers with new File(x);
    public static File getFile(String filename) { 
         return new File(filename);
    }

    public static boolean isEmpty(File file) {
        return file.length() > 0;
    }

    public static List<String> getLines(File file) throws Exception {
        return Files.readAllLines(Paths.get(file.getAbsolutePath()));
    }
}