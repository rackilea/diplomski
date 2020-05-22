public class CheckCombo implements ActionListener {

    JComboBox combo = null;

    public void actionPerformed(ActionEvent e) {

        JComboBox cb = (JComboBox) e.getSource();
        CheckComboStore store = (CheckComboStore) cb.getSelectedItem();
        CheckComboRenderer ccr = (CheckComboRenderer) cb.getRenderer();
        ccr.checkBox.setSelected((store.state = !store.state));
        if (store.id.equals("ALL")){
            for (int i = 0; i < combo.getItemCount(); i++){
                ((CheckComboStore)combo.getItemAt(i)).state = ccr.checkBox.isSelected();
            }
        }
    }

    private JPanel getContent() {

        String[] ids = { "north", "west", "south", "east", "ALL" };
        Boolean[] values = { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE };
        CheckComboStore[] stores = new CheckComboStore[ids.length];
        for (int j = 0; j < ids.length; j++)
            stores[j] = new CheckComboStore(ids[j], values[j]);
        combo = new JComboBox(stores);
        combo.setRenderer(new CheckComboRenderer());
        combo.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(combo);
        return panel;
    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new CheckCombo().getContent());
        f.setSize(300, 160);
        f.setLocation(200, 200);
        f.setVisible(true);
    }
}

/** adapted from comment section of ListCellRenderer api */
class CheckComboRenderer implements ListCellRenderer {

    JCheckBox checkBox;

    public CheckComboRenderer() {

        checkBox = new JCheckBox();
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        CheckComboStore store = (CheckComboStore) value;
        checkBox.setText(store.id);
        checkBox.setSelected(((Boolean) store.state).booleanValue());
        checkBox.setBackground(isSelected ? Color.red : Color.white);
        checkBox.setForeground(isSelected ? Color.white : Color.black);
        return checkBox;
    }
}

class CheckComboStore {

    String id;
    Boolean state;

    public CheckComboStore(String id, Boolean state) {

        this.id = id;
        this.state = state;
    }
}