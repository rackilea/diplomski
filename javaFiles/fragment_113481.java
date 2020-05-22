public class SwingSolution extends JFrame
{
    private JPanel componentPanel = null;   
    private JButton buttonWithWidth2 = null;    
    private JButton button2 = null; 
    private JButton buttonWithHeight2 = null;   
    private JButton button4 = null; 
    private JButton button5 = null;

    public JPanel getComponentPanel()
    {
       if(null == componentPanel)
       {
           componentPanel = new JPanel();
           GridBagLayout gridBagLayout = new GridBagLayout();
           componentPanel.setLayout(gridBagLayout);

           GridBagConstraints constraint = new GridBagConstraints();

           constraint.gridx = 0;
           constraint.gridy = 0;
           // Set gridwidth to 2 grids
           constraint.gridwidth = 2;
           buttonWithWidth2 = new JButton("Button Width 2");
           componentPanel.add(buttonWithWidth2, constraint);

           constraint.gridx = 2;
           constraint.gridy = 0;
           // set the gridwidth back to normal i.e. 1 grid
           constraint.gridwidth = 1;
           button2 = new JButton("Button 2");
           componentPanel.add(button2, constraint);

           constraint.gridx = 0;
           constraint.gridy = 1;
           // set the gridheight to 2
           constraint.gridheight = 2;
           buttonWithHeight2 = new JButton("Button Height 2");
           componentPanel.add(buttonWithHeight2, constraint);

           constraint.gridx = 1;
           constraint.gridy = 1;
           // set the gridheight back to normal i.e. 1 grid
           constraint.gridheight = 1;
           button4 = new JButton("Button 4");
           componentPanel.add(button4, constraint);

           constraint.gridx = 1;
           constraint.gridy = 2;
           button5 = new JButton("Button 5");
           componentPanel.add(button5, constraint);
       }

       return componentPanel;
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        SwingSolution main = new SwingSolution();

        frame.setTitle("Simple example");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        frame.setContentPane(main.getComponentPanel());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}