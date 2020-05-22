File[] contents = new File("path").listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        String name = pathname.getName().toLowerCase();
        return name.endsWith(".png")
                || name.endsWith(".jpg")
                || name.endsWith(".jpeg")
                || name.endsWith(".gif")
                || name.endsWith(".bmp");
    }
});