@Override
protected void beforeMain(final Form f) {
    f.removeAllCommands();

    Toolbar toolbar = new Toolbar();
    f.setToolbar(toolbar);
    toolbar.setTitleComponent(new Label("My Form Name", "Title"));
    toolbar.addCommandToOverflowMenu(edit);
    toolbar.addCommandToRightBar(backCommand);
    f.setBackCommand(backCommand);

    ...
}

@Override
protected void postMain(final Form f) {
    //fetch remote data here

    ...
}