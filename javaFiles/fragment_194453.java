canvas.addListener(SWT.MenuDetect, new Listener() {

    @Override
    public void handleEvent(Event event) {
        System.out.println("menu visible");
    }

});