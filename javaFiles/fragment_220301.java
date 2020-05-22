btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        JFrame frame = new JFrame();
        JFXPanel jfxPanel = new JFXPanel();
        Platform.runLater(() -> {
            Parent root = ... ; // create JavaFX content, can be in a separate class
            Scene scene = new Scene(root);
            jfxPanel.setScene(scene);
        });
        frame.add(jfxPanel);
        frame.setSize(...);
        frame.setVisible(true);
    }       
});