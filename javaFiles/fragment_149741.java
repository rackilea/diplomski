InputMap im = table.getInputMap();
ActionMap am = table.getActionMap();

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
am.put("delete", new AbstractAction() {

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("DeleteMe...");

    }
});