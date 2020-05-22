import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Options extends JFrame {
                //water option (button changes text on or off)
    //make a button listener

    JSlider renderDistance;
    JSlider grassDensity;
    JButton waterToggleButton;

    JLabel rdTitle;
    JLabel gdTitle;
    JLabel wtTitle;
    JButton buttonClose;

    static final int RD_MIN_VALUE = 0;
    static final int RD_MAX_VALUE = 1000;
    static final int RD_INIT_VALUE = 500;

    static final int GD_MIN_VALUE = 0;
    static final int GD_MAX_VALUE = 1000;
    static final int GD_INIT_VALUE = 500;

    public Options() {
        this.setTitle("Settings");

        createView();

        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void createView() {
        //Making panels and adding them to window*
        JPanel pOptions = new JPanel();
        this.add(pOptions);

        //These are for the labels that I added so people know which option they are using
        JPanel pOptionLabels = new JPanel(new GridBagLayout());
        pOptions.add(pOptionLabels);

        GridBagConstraints gbc = new GridBagConstraints();

        renderDistance = new JSlider(RD_MIN_VALUE, RD_MAX_VALUE, RD_INIT_VALUE);
        grassDensity = new JSlider(GD_MIN_VALUE, GD_MAX_VALUE, GD_INIT_VALUE);
        waterToggleButton = new JButton("On");

        rdTitle = new JLabel("Render Distance");
        gdTitle = new JLabel("Grass Density");
        wtTitle = new JLabel("Water Terrain Visibility");

                                //Initializing Objects*
                                //Giving objects some attributes using methods*
        renderDistance.setMinorTickSpacing(100);
        renderDistance.setMajorTickSpacing(500);
        renderDistance.setPaintTicks(true);
        renderDistance.setPaintLabels(true);

        grassDensity.setMinorTickSpacing(100);
        grassDensity.setMajorTickSpacing(500);
        grassDensity.setPaintTicks(true);
        grassDensity.setPaintLabels(true);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(2, 2, 2, 2);

        waterToggleButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (waterToggleButton.getText().equals("Off")) {
                    waterToggleButton.setText("On");
                } else {
                    waterToggleButton.setText("Off");

                }
            }
        });

                                //Giving objects some attributes using methods*
        //Add things to panel ex. p.add();
        pOptionLabels.add(rdTitle, gbc);
        gbc.gridy++;
        pOptionLabels.add(gdTitle, gbc);
        gbc.gridy++;
        pOptionLabels.add(wtTitle, gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        pOptionLabels.add(renderDistance, gbc);
        gbc.gridy++;
        pOptionLabels.add(grassDensity, gbc);
        gbc.gridy++;
        pOptionLabels.add(waterToggleButton, gbc);

    }

    public static void main(String[] args) {
        new Options();

    }

}