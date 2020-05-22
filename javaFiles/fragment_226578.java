import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SwitchComboBoxModels {

    public static void main(String[] args) {
        new SwitchComboBoxModels();
    }

    public SwitchComboBoxModels() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Map<String, ComboBoxModel> models;
        private JComboBox cbMain;
        private JComboBox cbSub;

        public TestPane() {
            models = new HashMap<>(25);
            models.put("Kitchen", createComboBoxModel("espresso_machine",
                    "coffee_machine",
                    "coffee_pot",
                    "kettle",
                    "toaster",
                    "microwave",
                    "oven",
                    "frying_pan",
                    "stand_mixer",
                    "extrator_fan",
                    "tv",
                    "compact_flurescent",
                    "flurescent_tube",
                    "dishwasher",
                    "freezer",
                    "blender",
                    "can_opener",
                    "cooking_range",
                    "popcorn_popper"));
            models.put("Laundry", createComboBoxModel("washing_machine",
                    "clothes_dryer",
                    "vacuum_handler",
                    "compact_fluorescent",
                    "iron"));

            ComboBoxModel mainModel = createComboBoxModel("Kitchen", "Laundry");

            cbMain = new JComboBox();
            cbSub = new JComboBox();
            cbMain.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cbSub.setModel(models.get((String) cbMain.getSelectedItem()));
                }
            });
            cbMain.setModel(mainModel);
            cbSub.setModel(models.get((String) cbMain.getSelectedItem()));

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(cbMain, gbc);
            add(cbSub, gbc);

        }

        protected ComboBoxModel createComboBoxModel(String... values) {

            return new DefaultComboBoxModel(values);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }
    }
}