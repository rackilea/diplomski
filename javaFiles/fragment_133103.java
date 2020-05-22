public class SQlUI {

    public static void main(String[] args) {

        SQlUI user = new SQlUI();
        user.go();
    }

    public void go() {

        JFrame frame = new JFrame();

        JPanel buttonsPanel = new JPanel();
        JButton insert = new JButton("INSERT");
        JButton update = new JButton("UPDATE");
        JButton delete = new JButton("DELETE");
        buttonsPanel.add(insert);
        buttonsPanel.add(update);
        buttonsPanel.add(delete);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(120);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        JPanel idPanel = new JPanel();
        JLabel idLabel = new JLabel("ID");
        JTextField idField = new JTextField(120);
        idPanel.add(idLabel);
        idPanel.add(idField);

        centerPanel.add(namePanel);
        centerPanel.add(idPanel);
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}