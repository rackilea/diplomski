morphia.getMapper().getOptions().setObjectFactory(new DefaultCreator() {
    @Override
    protected ClassLoader getClassLoaderForClass() {
        return JavaPlugin.getClassLoader();
    }
});