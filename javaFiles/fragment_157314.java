@UiHandler("testBox")
public void onKeyPress(KeyPressEvent event) {
    if (!"0123456789".contains(String.valueOf(event.getCharCode()))) {
        textBox.cancelKey();
    }
}