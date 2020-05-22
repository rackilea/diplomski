public class Test {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();

        JScrollPane scrollPane = new JScrollPane();     
        JPanel view = new JPanel();
        view.setLayout(new MigLayout());
        scrollPane.setViewportView(view);
        frame.setContentPane(scrollPane);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        List<JComponent> labels = update(view);

        frame.revalidate();

        printLocations(labels);
    }

    public static List<JComponent> update(JPanel view) {
        view.removeAll();

        List<JComponent> labels = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel("Label " + i);
            view.add(label);
            labels.add(label);
        }

        view.repaint();

        return labels;
    }

    private static void printLocations(List<JComponent> labels) {
        for (JComponent label : labels) {
            System.out.println(label.getLocation());
        }
    }

}