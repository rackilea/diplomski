XMLHttpRequest req = XMLHttpRequest.create();
req.open("HEAD", fileURL);
req.setOnReadyStateChange(new ReadyStateChangeHandler() {

    @Override
    public void onReadyStateChange(XMLHttpRequest xhr) {

        if (xhr.getReadyState() == XMLHttpRequest.DONE) {
            if (xhr.getStatus() == 200) {
                Window.open(fileURL, winTitle, "");
            } else {
                // TODO handle other status codes
            }
        }
    }
});
req.send();