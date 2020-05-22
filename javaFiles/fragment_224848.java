private void logout() {
    Window[] allWindows = Window.getWindows();
    for (Window w:allWindows) {
        w.setVisible(false);
        w.dispose();
    }
    returnToLoginWindow();
}