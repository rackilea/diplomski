private PopupWindow getPopupWindow() {

    @SuppressWarnings("deprecation") 
    final Iterator<Window> windows = Window.impl_getWindows();

    while (windows.hasNext()) {
        final Window window = windows.next();
        if (window instanceof PopupWindow) {
            if (window.getScene() != null && window.getScene().getRoot() != null) { 
                Parent root = window.getScene().getRoot();
                if (root.getChildrenUnmodifiable().size() > 0) {
                    Node popup = root.getChildrenUnmodifiable().get(0);
                    if (popup.lookup(".fxvk") != null) {
                        FXVK vk = (FXVK) popup.lookup(".fxvk");

                        return (PopupWindow) window;
                    }
                }
            }
            return null;
        }
    }
    return null;
}