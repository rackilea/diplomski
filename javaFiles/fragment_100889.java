final ConfigurationBuilder builder = new ConfigurationBuilder();
builder.addUrls(ClasspathHelper.forPackage(PathManager.MODULES_FOLDER, ClassLoader.getSystemClassLoader(),
            ClasspathHelper.contextClassLoader(), ClasspathHelper.staticClassLoader()));
builder.addScanners(new ResourcesScanner());
final Reflections reflections = new Reflections(builder);
final Set<String> resources = reflections.getResources(Pattern.compile(".*\\.xml"));