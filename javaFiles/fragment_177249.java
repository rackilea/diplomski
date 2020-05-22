public class ComboBoxUpdate extends JFrame implements PopupMenuListener {

    private JComboBox box;

    public ComboBoxUpdate() {
        // Init
        JPanel panel = new JPanel();
        box = new JComboBox();
        box.addItem("from start");

        box.addPopupMenuListener(this);

        panel.add(box);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        if (box.getItemCount() == 1) {
            box.removeAllItems();
            box.addItem("item 1");
            box.addItem("item 2");
            box.addItem("item 3");
        }
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
    }

    @Override
    public void popupMenuCanceled(PopupMenuEvent e) {
    }
}