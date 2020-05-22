private JMenuBar buildMenuBar() {

    class MenuAction extends AbstractAction {
        private static final long serialVersionUID = 1;

        @Override
        public void actionPerformed(ActionEvent event) {
            // Deliberately empty.
        }
    }

    Action fileMenuAction = new MenuAction();
    Action editMenuAction = new MenuAction();
    Action viewMenuAction = new MenuAction();
    Action helpMenuAction = new MenuAction();

    localizer.configure(fileMenuAction, "menu.file");
    localizer.configure(editMenuAction, "menu.edit");
    localizer.configure(viewMenuAction, "menu.view");
    localizer.configure(helpMenuAction, "menu.help");

    JMenu fileMenu = new JMenu(fileMenuAction);
    JMenu editMenu = new JMenu(editMenuAction);
    JMenu viewMenu = new JMenu(viewMenuAction);
    JMenu helpMenu = new JMenu(helpMenuAction);

    // etc.
}