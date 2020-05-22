final Custom[] customHolder = new Custom[1];

PlatformUI.getWorkbench().getDisplay().syncExec(() -> {
    customHolder[0] = getSomeCustom();
    customHolder[0].doSomething();
});

customHolder[0].doSomethingElse(true);