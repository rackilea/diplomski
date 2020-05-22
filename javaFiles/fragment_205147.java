public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
        Bubble_Chart_AWT demo = new Bubble_Chart_AWT("Bubble_Chart_AWT");
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.pack();
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
    });
}