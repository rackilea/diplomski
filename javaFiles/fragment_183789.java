inputWindow.setText(displayText);
inputWindow.post(new Runnable() {

    @Override
    public void run() {

        inputWindow.setCursorLocation(glyphCursorPosition);
    }

});