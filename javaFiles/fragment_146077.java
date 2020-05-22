import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TestJTable {

    public class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private final DeleteButtonListener bListener = new DeleteButtonListener();

        /**
         * Constructeur avec une checkBox
         * 
         * @param checkBox
         * @param count
         */
        @SuppressWarnings("deprecation")
        public ButtonEditor(JCheckBox checkBox) {
            // Par défaut, ce type d'objet travaille avec un JCheckBox
            super(checkBox);
            // On crée à nouveau notre bouton
            button = new JButton();
            button.setOpaque(true);
            // On lui attribue un listener
            button.addActionListener(bListener);

        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            // On précise le numéro de ligne à notre listener
            bListener.setRow(row);
            // Idem pour le numéro de colonne
            // On passe aussi le tableau en paramètre pour des actions
            // potentielles
            bListener.setTable(table);

            // On réaffecte le libelle au bouton
            button.setText(value == null ? "" : value.toString());
            // On renvoie le bouton
            return button;
        }

        class DeleteButtonListener implements ActionListener {

            private int row;
            private JTable table;

            public void setRow(int row) {
                this.row = row;
            }

            public void setTable(JTable table) {
                this.table = table;
            }

            @Override
            public void actionPerformed(ActionEvent event) {
                if (table.getRowCount() > 0) {
                    // On affiche un message
                    System.out.println("coucou du bouton: "
                            + ((JButton) event.getSource()).getText());
                    ((DefaultTableModel) table.getModel()).removeRow(this.row);
                    ButtonEditor.this.cancelCellEditing();
                }
            }
        }
    }

    private static final String[] title = { "X", "Nom", "SRM", "Rend.", "%",
            "Kg", };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestJTable().initUI();
            }
        });
    }

    protected void initUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel(title, 4);
        JTable table = new JTable(model);
        table.getColumn("X").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumn("X").setCellRenderer(new ButtonRenderer());
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

    public static class ButtonRenderer extends JButton implements
            TableCellRenderer {

        private static final Color beige = new Color(218, 217, 158);

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean isFocus, int row,
                int col) {
            setBackground(beige);
            // On écrit dans le bouton ce que contient la cellule
            setText(value != null ? value.toString() : "");
            // on retourne notre bouton
            return this;
        }
    }

}