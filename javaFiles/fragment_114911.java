// After the Applet Text has been updated
JSObject win = null;
try {
    win = (JSObject) JSObject.getWindow(Applet.this);
    win.call("updateText", new Object[] { textBox.getText() });
} catch (Exception ex) {
    // oops
}