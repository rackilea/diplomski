public JWindow initSplash(){
       JWindow window = new JWindow();
       final JFXPanel fxPanel = new JFXPanel();
       window.add(fxPanel);
       window.setVisible(true);
       window.setLocationRelativeTo(null);

        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                Scene scene = new Scene(new CustomFxSplash(), 475, 300, true);
                fxPanel.setScene(scene);
            }
        }
       return window;
}