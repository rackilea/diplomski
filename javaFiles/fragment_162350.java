public final class SettingsABC<T> {
    public static final SettingsABC<Integer> A = 
               new SettingsABC<>(new SettingDefinition<>("A", 123));
    public static final SettingsABC<String> B = 
               new SettingsABC<>(new SettingDefinition<>("B", "Hello"));
    public static final SettingsABC<Boolean> C = 
               new SettingsABC<>(new SettingDefinition<>("C", false));

    private final SettingDefinition<T> settingDefinition;

    // private constructor, so nobody else would instantiate it
    private SettingsABC(SettingDefinition<T> settingDefinition) {
            this.settingDefinition = settingDefinition;
    }

    public SettingDefinition<T> getDefinition() {
            return settingDefinition;
    }
}