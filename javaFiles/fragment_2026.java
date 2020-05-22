EventQueue.invokeLater(new Runnable() {

    @Override
    public void run() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        JFrame frame = new JFrame("Java 2048 By Xandru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Add the background
        ImagePanel background = new ImagePanel("src/images/2.png");
        frame.add(background);

        // Create the main Frame
        frame.pack();

        // Set dimensions
        frame.setSize(new Dimension(width, height));

        // Center it
        frame.setLocationRelativeTo(null);

        // Set visible
        frame.setVisible(true);

    }
});