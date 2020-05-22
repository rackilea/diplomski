public class CopyAction extends AbstractAction {

    private JList list;

    public CopyAction(JList list) {
        putValue(NAME, "Copy");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        putValue(SELECTED_KEY, "Copy stuff");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("All your copies belong to us");
    }

    public JList getList() {
        return list;
    }

}