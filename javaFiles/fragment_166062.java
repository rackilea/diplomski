public class Loader {

    public static void main(String[] args) {
        try {
            Set<URL> classPathList = new HashSet<URL>();
            classPathList.addAll(ClasspathHelper.forClassLoader());
            Set<Class<? extends Command>> result = new Reflections(new ConfigurationBuilder().setScanners(new SubTypesScanner()).setUrls(classPathList)).getSubTypesOf(Command.class);

            List<Command> commands = new ArrayList<Command>();

            for (Class<? extends Command> c : result) {
                System.out.println(c.getSimpleName());
                commands.add(c.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}