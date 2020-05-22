Object key = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .get(KeyStroke.getKeyStroke("ENTER"));
    final Action action = table.getActionMap().get(key);
    Action custom = new AbstractAction("wrap") {

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectionModel().getLeadSelectionIndex();
            if (row == table.getRowCount() - 1) {
                // do custom stuff
                // return if default shouldn't happen or call default after
                return;
            }
            action.actionPerformed(e);
        }

    };
    table.getActionMap().put(key, custom);