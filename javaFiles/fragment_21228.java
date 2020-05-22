public class Checkboxlistener extends JFrame {

    private JPanel jpAcc = new JPanel();
    private JList<String> checkBoxesJList;

    Checkboxlistener() {
        jpAcc.setLayout(new BorderLayout());
        String labels[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        checkBoxesJList = new JList<String>(labels);

        checkBoxesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(checkBoxesJList);

        jpAcc.add(scrollPane);

        getContentPane().add(jpAcc);
        pack();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Checkboxlistener cbl = new Checkboxlistener();
                cbl.setVisible(true);
            }
        });
    }
}