public class GraphFrame extends JFrame {

    GraphFrame() {
        final GraphPanel gPanel = new GraphPanel();
        gPanel.create();
        JButton button = new JButton(new AbstractAction("Update") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = JOptionPane.showInputDialog(rootPane,
                    "ENTER FIRST VALUE", "", JOptionPane.PLAIN_MESSAGE);
                String b = JOptionPane.showInputDialog(rootPane,
                    "ENTER SECOND VALUE", "", JOptionPane.PLAIN_MESSAGE);
                int aa = Integer.parseInt(a);
                int bb = Integer.parseInt(b);
                gPanel.update(aa, bb);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(gPanel, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static class GraphPanel extends JPanel {

        private DefaultCategoryDataset gData = new DefaultCategoryDataset();

        void create() {
            update(56, 20);
            JFreeChart chart = ChartFactory.createBarChart("", "", "", gData,
                PlotOrientation.VERTICAL, false, false, false);
            ChartPanel chartPanel = new ChartPanel(chart);
            this.add(chartPanel);
        }

        private void update(int value1, int value2) {
            gData.clear();
            gData.setValue(value1, "What you saved", "");
            gData.setValue(value2, "What you paid", "");
        }
    }

    public static void main(String args[]) {
        new GraphFrame();
    }
}