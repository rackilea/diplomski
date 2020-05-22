interface Module {
    void setStructure(ModuleCollection collection);
}

interface ModuleMaker<T extends Module> {
    T makeModule();
}

class ModuleCollection {
    private final List<Module> modules = new ArrayList<>();

    public void addModule(ModuleMaker<?> maker) {
        Module module = maker.makeModule();
        module.setStructure(this);
        modules.add(module);
    }
}