import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MapWindowController extends JFrame implements ActionListener, ItemListener {

    private static final int WIDTH = 600, HEIGHT = 800;
    private static final int SETTINGS_WIDTH = 600, SETTINGS_HEIGHT = 200;
    private static final int NUM_MAP_TYPE = 2;
    private static final int NUM_ALGORITHM_TYPE = 4;
    private static final int MAP_IMAGE_SIZE = 400, ACTUAL_MAP_SIZE = 10;

    private JButton run;
    private JCheckBox[] map_type;
    private JCheckBox[] algorithm_type;
    JPanel content = new JPanel();
    JPanel settings_panel = new JPanel();
    private JPanel mapPane = new JPanel(new BorderLayout());

    ButtonGroup bgMap;
    ButtonGroup bgAlgorithm;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new MapWindowController();
            }
        });
    }

    public MapWindowController() {

        setLocationRelativeTo(null);
        setTitle("HPA* Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 0.25;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(settings_panel, gbc);
        gbc.gridy++;
        gbc.weighty = 0.75;
        content.add(mapPane, gbc);

        try {
            mapPane.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/Map.png")))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        add(content);
        /*GridBagConstraints c = new GridBagConstraints();
         c.fill = GridBagConstraints.HORIZONTAL;
         c.gridx = 0;
         c.gridy = 0;*/
        instantiateSettingsPanel();
        //panel.add(settings);
        /*c.fill = GridBagConstraints.HORIZONTAL;
         c.gridx = 0;
         c.gridy = 1;*/

        pack();
        setLocationByPlatform(true);
        setVisible(true);


    }

    public void instantiateSettingsPanel() {
        settings_panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        //this.setLayout(null);
        map_type = new JCheckBox[NUM_MAP_TYPE];

        map_type[0] = new JCheckBox("Sparse");
        map_type[0].setSelected(true);

        map_type[1] = new JCheckBox("Maze");
        map_type[1].setSelected(false);

        algorithm_type = new JCheckBox[NUM_ALGORITHM_TYPE];

        algorithm_type[0] = new JCheckBox("A*");
        algorithm_type[0].setSelected(true);

        algorithm_type[1] = new JCheckBox("HPA*");
        algorithm_type[1].setSelected(false);

        algorithm_type[2] = new JCheckBox("TA*");
        algorithm_type[2].setSelected(true);

        algorithm_type[3] = new JCheckBox("PTHPA*");
        algorithm_type[3].setSelected(false);

        bgMap = new ButtonGroup();
        bgAlgorithm = new ButtonGroup();

        settings_panel.setMaximumSize(new Dimension(600, 200));
        for (int i = 0; i < NUM_MAP_TYPE; i++) {
            bgMap.add(map_type[i]);
            map_type[i].addItemListener(this);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i + 1;
            settings_panel.add(map_type[i], c);
        }

        for (int i = 0; i < NUM_ALGORITHM_TYPE; i++) {
            bgAlgorithm.add(algorithm_type[i]);
            algorithm_type[i].addItemListener(this);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = i + 1;
            settings_panel.add(algorithm_type[i], c);
        }

        run = new JButton("Run");
        run.addActionListener(this);
        settings_panel.add(run);
    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        //if(source == )
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        String algorithm = "A*";
        String map = "Sparse";
        for (int i = 0; i < algorithm_type.length; i++) {
            if (algorithm_type[i].isSelected()) {
                algorithm = algorithm_type[i].getText();
                break;
            }
        }

        for (int i = 0; i < map_type.length; i++) {
            if (map_type[i].isSelected()) {
                map = map_type[i].getText();
                break;
            }
        }

        if (source == run) {
//            if (map.equals("Sparse")) {
//                map_model.createRandomObstaclesSparse(10, 1);
//            } else {
//                map_model.createRandomObstaclesMaze(1);
//            }
//            map_model.startPathfinding(algorithm, 0, true);
//            map_view.setMapScale(ACTUAL_MAP_SIZE);
//            map_view.setMapModel(map_model);
        }
    }
}