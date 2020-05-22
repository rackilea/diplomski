// this function defines menu items and their listeners
public JMenuItem AddMenuItem(JMenu menu, String name) {
    JMenuItem menuItem = new JMenuItem(name);
    menu.add(menuItem);

    menuItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            SwitchPanel(new MyPersonalJPanel());
        }
    });

    return menuItem;
}