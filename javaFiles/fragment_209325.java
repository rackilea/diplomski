KeyStroke accelerator =  b.getAccelerator();
String acceleratorText = "";
if (accelerator != null) {
    int modifiers = accelerator.getModifiers();
    if (modifiers > 0) {
        acceleratorText = KeyEvent.getKeyModifiersText(modifiers);
        acceleratorText += "+";
    }
    acceleratorText += KeyEvent.getKeyText(accelerator.getKeyCode());
}