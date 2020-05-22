Window.addWindowClosingHandler(new Window.ClosingHandler() {

    @Override
    public void onWindowClosing(ClosingEvent event) {
        event.setMessage("You sure?");
    }
});

Window.addCloseHandler(new CloseHandler<Window>() {

    @Override
    public void onClose(CloseEvent<Window> event) {
        //Execute code when window closes!
    }
});