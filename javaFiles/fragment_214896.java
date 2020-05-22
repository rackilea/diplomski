import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class PanelTableEditorTest extends JFrame
{

    private JTable table;

    public PanelTableEditorTest()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {

        }
        this.setLayout(new BorderLayout());
        table = new JTable(4, 4);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(true);
        table.setSurrendersFocusOnKeystroke(false);
        table.setDefaultEditor(Object.class,new SimpleMultiRowCellEditor());
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(java.awt.event.
                        KeyEvent.VK_F2, 0), "none");
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(java.awt.event.
                        KeyEvent.VK_ENTER, 0), "startEditing");

        this.add(table.getTableHeader(), BorderLayout.NORTH);

        this.add(table, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PanelTableEditorTest();

            }
        });
    }

    public class SimpleMultiRowCellEditor extends DefaultCellEditor
    {
        private EventObject event;
        final JPanel panel;
        private final JButton rowCount;

        public SimpleMultiRowCellEditor()
        {
            super(new JTextField());
            this.setClickCountToStart(1);

            rowCount = new JButton();
            rowCount.setVisible(true);
            panel = new TableEditorPanel();
            panel.setRequestFocusEnabled(true);
            panel.setOpaque(false);
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            panel.add(rowCount);
            panel.add(editorComponent);
        }

        public boolean isCellEditable(EventObject anEvent)
        {
            event=anEvent;
            return super.isCellEditable(anEvent);
        }

        public Component getTableCellEditorComponent(final JTable table, final Object val, final boolean isSelected, final int row, final int column)
        {
            rowCount.setText("1");
            delegate.setValue(val);
            if(event instanceof KeyEvent || event==null)
            {
                final Caret caret = ((JTextField)editorComponent).getCaret();
                caret.setDot(0);
                ((JTextField)editorComponent).setText("");                
            }
            return panel;
        }

        class TableEditorPanel extends JPanel
        {

            public void addNotify(){
                super.addNotify();
                editorComponent.requestFocus();
            }

            protected boolean processKeyBinding(KeyStroke ks, KeyEvent e, int condition, boolean pressed){
                InputMap map = editorComponent.getInputMap(condition);
                ActionMap am = editorComponent.getActionMap();

                if(map!=null && am!=null && isEnabled()){
                    Object binding = map.get(ks);
                    Action action = (binding==null) ? null : am.get(binding);
                    if(action!=null){
                        return SwingUtilities.notifyAction(action, ks, e, editorComponent,
                                e.getModifiers());
                    }
                }
                return false;
            }
        }
    }
}