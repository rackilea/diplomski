public static void refresh() {
    try {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                text.setText(entityOverviewHTML());
                bringToFront();
            }
        });
    } catch (InvocationTargetException | InterruptedException e) {
        e.printStackTrace();
    }
}