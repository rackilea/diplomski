@Override
protected ClassLoader createRobolectricClassLoader(Setup setup, SdkConfig sdkConfig) {
    return super.createRobolectricClassLoader(new ExtraShadows(setup), sdkConfig);
}

class ExtraShadows extends Setup {
    private Setup setup;

    public ExtraShadows(Setup setup) {
        this.setup = setup;
    }

    public boolean shouldInstrument(ClassInfo classInfo) {
        boolean shoudInstrument = setup.shouldInstrument(classInfo);
        return shoudInstrument
                || classInfo.getName().equals(OriginalMessenger.class.getName());
    }
}