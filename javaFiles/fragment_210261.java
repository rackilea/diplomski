setAdapter(new UISpecAdapter() {
    public Window getMainWindow() {
        final Window[] result = new Window[1];
        WindowInterceptor.init(new MainClassTrigger(Main.class, new String[0]))
            .processTransientWindow()
            .process(new WindowHandler() {
                public Trigger process(Window window) throws Exception {
                result[0] = window;
                return Trigger.DO_NOTHING;
                }
            })
        .run();
        return result[0];
    }
});