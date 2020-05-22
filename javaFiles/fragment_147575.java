public class MainFrame2 extends JFrame {

    /** An interface that abstracts creation of a "Module" */
    public interface ModuleFactory {
        public String getTitle();
        public Component createModule(Api api);
    }

    /** A Place to register modules */
    public static enum ModuleRegistry {
        INSTANCE;

        private final List<ModuleFactory> leftModules = new ArrayList<ModuleFactory>();
        public void registerModuleForLeftPanel(ModuleFactory factory) {
            leftModules.add(factory);
        }
        private void addModulesTo(MainFrame2 mainFrame2, Api api) {
            for (ModuleFactory factory : leftModules) {
                mainFrame2.addModuleToLeftPanel(factory.getTitle(), factory.createModule(api));
            }
        }
    }

    /** Creates an instance of MainFrame2 with all registered modules */
    public static MainFrame2 newInstance() {
        MainFrame2 result = new MainFrame2();
        ModuleRegistry.INSTANCE.addModulesTo(result, result.api);
        return result;
    }

    // ...
}