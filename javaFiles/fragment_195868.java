@Override
    public void restored() {
        WindowManager.getDefault().invokeWhenUIReady(() -> {
            /**
             * All windows start opened. Populated the ViewManager. It is
             * important to configure all TopComponents with: 
             * persistenceType = TopComponent.PERSISTENCE_NEVER or TopComponent.PERSISTENCE_ONLY_OPENED
             * and openAtStartup = true
             */
            ViewManager manager = Lookup.getDefault().lookup(ViewManager.class);
            WindowManager.getDefault().getRegistry().getOpened().stream()
                    .forEach((tc) -> {
                        manager.hideTopComponent(tc.getClass());
                    });
            manager.loadRole(Tool.LOBBY);
        });
    }