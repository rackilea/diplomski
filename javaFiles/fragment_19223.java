public static void main(String[] args) throws IOException {
     String name = "Outer.zip";
     FileInputStream input = new FileInputStream(new File(name));
     readZip(input, name);
}

public static void readZip(final InputStream in, final String name) throws IOException {
    final ZipInputStream zin = new ZipInputStream(in);
    ZipEntry entry;
    while ((entry = zin.getNextEntry()) != null) {
        if (entry.getName().toLowerCase().endsWith(".zip")) {
            readZip(zin, name + "/" + entry.getName());
        } else {
            readFile(zin, entry.getName());
        }
    }
}

private static void readFile(final InputStream in, final String name) {
    String contents = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));
    System.out.println(String.format("Contents of %s: %s", name, contents));
}