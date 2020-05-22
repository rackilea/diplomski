private enum Roles {CODER, MANAGER, USER}

JComboBox box1 = new JComboBox(Roles.values());
JComboBox box2 = new JComboBox();
public RoleSelection() {
    box1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            box2.removeAllItems();
            box2.addItem(null); // For those with only one role
            for (Roles role : Roles.values()) {
                if (role != box1.getSelectedItem()) {
                    box2.addItem(role);
                }
            }
        }
    });
    // Trigger a selection even to update the second box
    box1.setSelectedIndex(0);

    add(box1, BorderLayout.NORTH);
    add(box2, BorderLayout.SOUTH);
    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public static void main(String[] args) {
    new RoleSelection().setVisible(true);
}