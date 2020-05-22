class FileAction extends AbstractAction {

    JTextPane target;
    File file;

    public FileAction(JTextPane target, File file) {
        this.target = target;
        this.file = file;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // render file in target
    }
}