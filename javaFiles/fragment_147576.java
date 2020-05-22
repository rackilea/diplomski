class User {
    public static void main(String[] args) {
        // static bootstrap code - needs to be run once at the beginning - can be anywhere
        // if you want to add modules you can do it here
        MainFrame2.ModuleRegistry.INSTANCE.registerModuleForLeftPanel(new ModuleFactory() {
            @Override
            public String getTitle() {
                return "Teste";
            }
            @Override
            public Component createModule(Api api) {
                return new PingPong(api);
            }
        });
        // create a mainframe
        MainFrame2.newInstance();
    }
}