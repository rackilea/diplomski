@Override
public void start(Stage primaryStage) {

    SwingUtilities.invokeLater( () -> {
        // Create 3 JFrames
        jframe1 = new JFrame("JFrame 1");
        jframe1.setBounds(50, 50, 200, 150);
        jframe1.setVisible(true);

        jframe2 = new JFrame("JFrame 2");
        jframe2.setBounds(275, 50, 200, 150);
        jframe2.setVisible(true);

        jframe3 = new JFrame("JFrame 3");
        jframe3.setBounds(500, 50, 200, 150);
        jframe3.setVisible(true);
    });

    // Create 3 buttons that close each one JFrame
    // Button 1
    Button closeButton1 = new Button();
    closeButton1.setText("Close JFrame 1");
    closeButton1.setOnAction(event -> {
        SwingUtilities.invokeLater(() -> {
            jframe1.setVisible(false);
            System.out.print("Closing JFrame 1...");
            jframe1.dispose();
        });
    });

    // similarly for other button handlers...

}