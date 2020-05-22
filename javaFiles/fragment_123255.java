Path spreadsheetsDir = Files.createTempDirectory(null);
Path excel = null;

while ((ze = zin.getNextEntry()) != null) {
    String name = ze.getName();
    if (name.endsWith(".xlsx")) {
        excel = spreadsheetsDir.resolve(name));
        Files.copy(zin, excel);
    } else if (name.endsWith(".svg")) {
        AnimationSvg animationSvg = new AnimationSvg();
        animationSvg.setName(name);
        animationSvg.setSvgContent(
            new String(zin.readAllBytes(), StandardCharsets.UTF_8));
        animationSvgs.add(animationSvg);
    }
    zin.closeEntry();
}