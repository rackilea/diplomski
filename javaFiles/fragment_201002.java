AlloyLookAndFeel laf = new AlloyLookAndFeel(theme) {
    @Override
    public UIDefaults getDefaults() {
        UIDefaults defs = new UIDefaults();

        defs.putAll(UIManager.getLookAndFeelDefaults());

        initClassDefaults(defs);
        initSystemColorDefaults(defs);
        initComponentDefaults(defs);

        defs.put("Menu.opaque", true);

        return defs;
    }
};