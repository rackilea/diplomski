uiBindingRegistry.registerKeyBinding(
        new KeyEventMatcher(SWT.NONE, SWT.CR),
        new KeyEditAction());
uiBindingRegistry.registerKeyBinding(
        new KeyEventMatcher(SWT.MOD1, SWT.CR),
        new KeyEditAction());