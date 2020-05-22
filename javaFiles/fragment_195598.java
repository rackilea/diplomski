myPanel.addDomHandler(new KeyUpHandler() {

    @Override
    public void onKeyUp(KeyUpEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_DOWN) {
            // Reduce page number
        }
    }
}, KeyUpEvent.getType());