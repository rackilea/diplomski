uiBindingRegistry.registerKeyBinding(
        new LetterOrDigitKeyEventMatcher(),
        new KeyEditAction());
uiBindingRegistry.registerKeyBinding(
        new LetterOrDigitKeyEventMatcher(SWT.MOD2),
        new KeyEditAction());