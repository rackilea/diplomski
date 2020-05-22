try {
    File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    System.out.println(f.getAbsolutePath());
} catch (URISyntaxException ex) {
    throw new RuntimeException(ex);
}