private static boolean isMaximized(int state) {
    return (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
}

// ...

    frame.addWindowStateListener(new WindowStateListener() {
        public void windowStateChanged(WindowEvent event) {
            boolean isMaximized = isMaximized(event.getNewState());
            boolean wasMaximized = isMaximized(event.getOldState());

            if (isMaximized && !wasMaximized) {
                System.out.println("User maximized window.");
            } else if (wasMaximized && !isMaximized) {
                System.out.println("User unmaximized window.");
            }
        }
    });