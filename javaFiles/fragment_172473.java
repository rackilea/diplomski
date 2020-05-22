public enum SessionLockModSchema {
    INSTANCE;

    private final Set<String> lockedModels = new HashSet<>;

    public void lockSchema(Model model){
        synchronized(lockedModels) {
            lockedModels.add("" + model.getId());
        }
    }

    public void unlockSchema(Model model){
        synchronized(lockedModels) {
            lockedModels.remove("" + model.getId());
        }
    }


    public void isSchemaLocked(Model model){
        synchronized(lockedModels) {
            return lockedModels.contains("" + model.getId());
        }
    }
}