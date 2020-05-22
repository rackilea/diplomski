public class Window {
    public static class StackExchangeQ extends JPanel {
        private DefaultComboBoxModel<String> yearModel;

        public void setYears(ArrayList<String> userYears) {
            yearModel.removeAllElements();
            userYears.forEach(yearModel::addElement);
        }

        public StackExchangeQ() {
            this.setLayout(new BorderLayout());
            JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            this.add(menuPanel, BorderLayout.PAGE_START);

            yearModel = new DefaultComboBoxModel<>();
            JComboBox<String> yearSelect = new JComboBox<String>(yearModel);
            menuPanel.add(yearSelect, BorderLayout.PAGE_START);
        }
    }

    public Window() {
        JFrame frame = new JFrame();
        frame.getContentPane().setForeground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<String> yearList = new ArrayList<String>();
        yearList.add("All");
        yearList.add("2019");
        StackExchangeQ fakePanel = new StackExchangeQ();
        fakePanel.setYears(yearList);
        frame.add(fakePanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window());
    }
}