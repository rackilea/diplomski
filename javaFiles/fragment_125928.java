final Class<?> cls = TempCodes.class;
String[] names = new File(cls.getResource("").toURI()).list(new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.startsWith(cls.getSimpleName());
    }
});
for (String name : names) {
    System.out.println(name);
}