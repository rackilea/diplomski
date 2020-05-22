public class FrequentQuestions extends JFrame {

    final JLabel label = new JLabel("TEXT");

    public FrequentQuestions() {

        JList<String> list = new JList<String>(new String[]{"A", "B"});
        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {

                if (e.getValueIsAdjusting())
                    return;
                JList<String> list = (JList<String>) e.getSource();
                label.setText(list.getSelectedValue());
            }
        });

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, label);
        add(split);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new FrequentQuestions();
    }
}