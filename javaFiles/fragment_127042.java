public static void registerAllFonts(String fontsDir) {
    try {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final File jarFile = new File(FontUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        if (FileUtil.isJarFile(jarFile)) {
            if(fontsDir.startsWith("/"))
                fontsDir = fontsDir.substring(1);
            JarFile jar = new JarFile(jarFile);
            Enumeration<JarEntry> entries = jar.entries();
            ArrayList<JarEntry> jarEntries = Collections.list(entries);
            final String finalFontsDir = fontsDir;
            List<JarEntry> fonts = jarEntries.stream()
                    .filter(f -> f.getName().startsWith(finalFontsDir) && 
                            !f.getName().equals(finalFontsDir))
                    .collect(Collectors.toList());
            fonts.forEach(f -> {
                try {
                    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, jar.getInputStream(f)));
                } catch (FontFormatException | IOException e) {
                    e.printStackTrace();
                }
            });
            jar.close();
        } else {
            URL url = FontUtil.class.getResource(fontsDir);
            if (url != null) {
                File file = new File(url.toURI());
                if (file.listFiles() != null)
                    for (File f : file.listFiles()) {
                        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, f));
                    }
            }
        }
    } catch (IOException | FontFormatException | URISyntaxException e) {
        ExceptionUtil.generateErrorLog(e);
    }
}