static class TodoGUI$Lambda$1 implements java.awt.Event.ActionListener {
    private final java.util.List list;
    private final java.awt.TextField itemField;

    TodoGUI$Lambda$1(java.util.List list, java.awt.TextField itemField) {
        this.list = list;
        this.itemField = itemField;
    }

    @Override
    public void actionPerformed(java.awt.Event.ActionEvent e) {
        TodoGUI.lambda$1(list, itemField);
    }

    static java.awt.Event.ActionListener getInstance(
        java.util.List list,
        java.awt.TextField itemField) {

        return new TodoGUI$Lambda$1(list, itemField);
    }
}