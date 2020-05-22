public class Main extends JFrame implements ActionListener
{
    private JPanel componentPanel = null;   
    private JPanel loginPanel = null;    
    private JLabel loginLabel = null;    
    private JPanel optionPanel = null;
    private JLabel optionLabel = null; 
    private JButton loginButton = null;

    public JPanel getComponentPanel()
    {
       if(null == componentPanel)
       {
           componentPanel = new JPanel();
           GridBagLayout gridBagLayout = new GridBagLayout();
           componentPanel.setLayout(gridBagLayout);

           GridBagConstraints constraint = new GridBagConstraints();
           constraint.insets = new Insets(10, 10, 10, 10);

           loginPanel = new JPanel();           
           constraint.gridx = 0;
           constraint.gridy = 0;
           loginPanel.setMinimumSize(new Dimension(100, 50));
           loginPanel.setPreferredSize(new Dimension(100, 50));
           loginPanel.setMaximumSize(new Dimension(100, 50));
           loginPanel.setBorder(
                   BorderFactory.createLineBorder(Color.RED));

           loginLabel = new JLabel("Login Panel");
           loginPanel.add(loginLabel);
           componentPanel.add(loginPanel, constraint);

           optionPanel = new JPanel();         
           constraint.gridx = 0;
           constraint.gridy = 0;
           optionPanel.setMinimumSize(new Dimension(100, 50));
           optionPanel.setPreferredSize(new Dimension(100, 50));
           optionPanel.setMaximumSize(new Dimension(100, 50));
           optionPanel.setBorder(
                   BorderFactory.createLineBorder(Color.BLUE));

           optionLabel = new JLabel("Option Panel");
           optionPanel.add(optionLabel);
           componentPanel.add(optionPanel, constraint);

           loginButton = new JButton("Login");
           constraint.gridx = 0;
           constraint.gridy = 1;
           loginButton.addActionListener(this);
           componentPanel.add(loginButton, constraint);
       }       
       return componentPanel;
    }

    public void actionPerformed (ActionEvent evt) 
    {
        loginPanel.setVisible(false);
        loginButton.setEnabled(false);
        optionPanel.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        Main main = new Main();

        frame.setTitle("Simple example");
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);

        frame.setContentPane(main.getComponentPanel());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}