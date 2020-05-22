public class TestOpenSave {

    private static void createAndShowGui() {
        OpenSave openSave = new OpenSave();
        JFrame frame = new JFrame("OpenSave");

        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton(new GetImageAction("Open Image", frame, openSave)));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(openSave);
        frame.add(btnPanel, BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}