public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {

            // create JDialog on EDT
            final JDialog dialog = new JDialog((JDialog)null, "JDialog");

            // initialize FX platform and create JFXPanel
            final JFXPanel jfxPanel = new JFXPanel();

            // add resize listener for JFXPanel
            jfxPanel.addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    // not called in 1.8.0_45
                    System.out.println("JFXPanel.getSize(): "+jfxPanel.getSize());
                }
            });

            // set FX Scene on JFXPanel and wait until finished
            runAndWait(new Runnable() {                
                public void run() {
                    Text text = TextBuilder.create().text("JavaFx content").y(20).build();
                    Group root = new Group(text);
                    Scene scene = new Scene(root);
                    jfxPanel.setScene(scene);
                }
            });

            // show undecorated modal JDialog with FX content
            System.out.println("JFXPanel.getPreferredSize(): "+jfxPanel.getPreferredSize());
            dialog.setUndecorated(true);
            dialog.add(jfxPanel);
            dialog.pack();
            dialog.setModal(true);
            System.out.println("JDialog.setVisible()");
            dialog.setVisible(true);
        }
    });
}

private static void runAndWait(Runnable r) {
    try {
        FutureTask<Object> task = new FutureTask<Object>(r, null);
        Platform.runLater(task);
        task.get();
    }
    catch (Exception e) {
        throw new RuntimeException(e);
    }
}