public class LuaApplicationSettings implements PersistentStateComponent<LuaApplicationSettings> {
    public boolean INCLUDE_ALL_FIELDS_IN_COMPLETIONS = false;
    public boolean SHOW_TAIL_CALLS_IN_GUTTER = true;
    public boolean ENABLE_TYPE_INFERENCE = true;

    @Override
    public LuaApplicationSettings getState() {
        return this;
    }

    @Override
    public void loadState(LuaApplicationSettings state) {
         XmlSerializerUtil.copyBean(state, this);
    }

    public static LuaApplicationSettings getInstance() {
        return ServiceManager.getService(LuaApplicationSettings.class);
    }
}