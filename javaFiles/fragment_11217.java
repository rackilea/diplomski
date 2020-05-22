import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TableKeyBindings {

    public static void main(String[] args) {
        new TableKeyBindings();
    }

    public TableKeyBindings() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                DefaultTableModel model = new DefaultTableModel(new String[]{"Row", "Name"}, 0);
                String[] names = new String[]{
                    "Lyveb", "Eldw", "Sutaw", "Radine", "Namhin", "Draos", "Et'rad",
                    "Deloef'c", "Ashlyeu", "Urner", "Nalund", "Rothem", "En'saya", "Torelm",
                    "Sulyc-it", "Ranray", "Denehin", "Zhayss", "Untechustos", "Aldh", "Tastintin",
                    "Burl", "Lyeril", "Trohliss", "Lehub", "Feyef", "Tutsul", "Ingjsam",
                    "When", "Worunde", "Ashtai", "Undoc", "Nyril", "Ightigar", "Umach",
                    "Ceracki", "Ler'elda", "Ray'vesa", "Echril", "Chrorodang", "Oskim", "Mos'tas",
                    "Siusk", "Yertas", "Queler", "Parehy", "Essr", "Shyhon", "Inep",
                    "Yeraer", "Inand", "Osutur", "Aryny", "Vycel", "Roolt", "Ceriss-kin",
                    "Age'augha", "Lelysa", "Ahaty", "Engpolskel", "Kulal", "Ardlper", "Lonuru",
                    "Belyf", "Chroozis", "Rodir", "Dralech", "Undvorrod", "Aqueo", "Yshya",
                    "Eldrad", "Umbur", "Ina'pola", "Hon'er", "Rientai", "Wareph", "Urnil'l",
                    "Et'inee", "Kyest", "Rodinga", "Yenet", "Fothund", "Ackgcer", "Estbanos",
                    "Seroughrad", "Nyer", "Tortiatia", "Dosac", "Moimash", "Whiril", "Oundi",
                    "Sayangrak", "Taqh", "Fidad", "Elmom", "Sayvera", "Imsayo", "Elmsam",
                    "Hubame", "Phorileng", "Bel'ves", "Awit", "Kelvesonhin", "Ingpol", "Ough'ther",
                    "Inaine", "Rilck", "Shys", "Ightl", "Vesangar", "Queineo", "Jyunt",
                    "Aleack", "Ageat", "Cysod", "Deluju", "Oldl", "Alent", "Tia'dele"};

                int row = 0;
                for (String name : names) {
                    model.addRow(new String[]{Integer.toString(++row), name});
                }

                JTable table = new JTable(model);
                InputMap inputMap = table.getInputMap(JComponent.WHEN_FOCUSED);
                ActionMap actionMap = table.getActionMap();

                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "Show");
                actionMap.put("Show", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTable table = (JTable)e.getSource();
                        int row = table.getSelectedRow();
                        if (row != -1) {

                            row = table.convertRowIndexToModel(row);
                            String name = (String) table.getModel().getValueAt(row, 1);

                            JOptionPane.showMessageDialog(null, name, "Show", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}