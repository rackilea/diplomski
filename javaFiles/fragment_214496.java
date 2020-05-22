public class ClearList extends JFrame {

    String[] list1 = new String[] {"AAAA", "BBBB", "CCCC"};
    String[] list2 = new String[] {"1111", "2222", "3333"};
    DefaultListModel<String> model = new DefaultListModel<>();

    ClearList() {

        JList<String> list = new JList<>(model);
        addElements(list1);

        JButton button = new JButton("Repopulate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                model.clear();
                addElements(list2);
            }
        });

        getContentPane().add(list);
        getContentPane().add(button, BorderLayout.LINE_START);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addElements(String[] elements) {

        for (String s : elements)
            model.addElement(s);
    }

    public static void main(String[] args) {

        new ClearList();
    }
}