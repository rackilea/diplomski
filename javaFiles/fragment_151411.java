class MyAction extends AbstractAction {
    public MyAction(String text) {
        super(text);
        putValue(ACTION_COMMAND_KEY, "one"),
    }
    //...