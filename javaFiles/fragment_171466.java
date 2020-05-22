import java.awt.*;
import javax.swing.*;

public class AppletLayout extends JApplet
{
    private JTextField noNodeField;
    private JTextField timeSimField;
    private JTextField iniEngField;
    private JTextField ampConsField;
    private JTextField engReqField; 

    private JComboBox selModeCombo;
    private JComboBox distPattCombo;

    private JButton runSimButton;
    private JButton logButton;
    private JButton detailNodeButton;

    private String[] selectionModelString = {"", "Gaussian RadioModel"
                                               , "Rayleigh RadioModel"};

    private String[] distPatternString = {"", "Rectangular Pattern"
                                               , "Linear Pattern"
                                               , "Random Pattern"}; 


    public void init()
    {
        try
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    createAndDisplayGUI();
                }
            });
        }
        catch(Exception e)
        {
            System.err.println("Unable to Create and Display GUI : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createAndDisplayGUI()
    {
        JLabel noNodeLabel = new JLabel("Enter the No. of Nodes :", JLabel.LEFT);
        noNodeField = new JTextField(5);

        JLabel timeSimLabel = new JLabel("Enter time of Simulation :", JLabel.LEFT);
        timeSimField = new JTextField(5);

        JLabel iniEngLabel = new JLabel("Initial Energy Of Each Sensor Node :", JLabel.LEFT);
        iniEngField = new JTextField("10^-4 Joules");

        JLabel ampConsLabel = new JLabel("Amplifier Constant :", JLabel.LEFT);
        ampConsField = new JTextField("10^-12 Joules");

        JLabel engReqLabel = new JLabel("Energy Required To Activate Transmitter/Reciever :", JLabel.LEFT);
        engReqField = new JTextField("50 ^ -9 Joules");

        JLabel selModeLabel = new JLabel("Select Radio Model :", JLabel.LEFT);
        selModeCombo = new JComboBox(selectionModelString);

        JLabel distPattLabel = new JLabel("Distribution Pattern :", JLabel.LEFT);
        distPattCombo = new JComboBox(selectionModelString);

        runSimButton = new JButton("Run Simulation");
        logButton = new JButton("View Log");
        detailNodeButton = new JButton("Details of Node");

        JComponent contentPane = (JComponent) getContentPane();

        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        topPanel.setLayout(new GridLayout(0, 2));
        topPanel.add(noNodeLabel);
        topPanel.add(noNodeField);
        topPanel.add(timeSimLabel);
        topPanel.add(timeSimField);
        topPanel.add(iniEngLabel);
        topPanel.add(iniEngField);
        topPanel.add(ampConsLabel);
        topPanel.add(ampConsField);
        topPanel.add(engReqLabel);
        topPanel.add(engReqField);
        topPanel.add(selModeLabel);
        topPanel.add(selModeCombo);
        topPanel.add(distPattLabel);
        topPanel.add(distPattCombo);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new GridLayout(0, 1, 5, 5));
        buttonPanel.add(runSimButton);
        buttonPanel.add(logButton);
        buttonPanel.add(detailNodeButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5, 5));
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.LINE_END);

        contentPane.add(mainPanel, BorderLayout.PAGE_START);

        setSize(1000, 600);
    }
}