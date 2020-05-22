Upload upload = new Upload();
upload.setImmediate(true); // if you want to start upload after selection
upload.addStyleName("my-upload");
MenuBar menuBar = new MenuBar();
menuBar.addItem("Caption", new Command() {
    private static final long serialVersionUID = 1L;

    @Override
    public void menuSelected(MenuItem selectedItem) {
        JavaScript.getCurrent().execute(
            "document.getElementsByClassName('gwt-FileUpload')[0].click()");
    }
});
addComponent(upload);
addComponent(menuBar);