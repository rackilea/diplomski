public class MyApplet extends Applet{
    private static final long serialVersionUID = 1L;
    private JTextArea input_data;
    private JTextArea input_jmax;
    private JTextArea input_gibbs;
    private JTextArea input_burnin;
    private JTextArea output_text;
    private JLabel output_graph;
    private JLabel output_burn1;
    private JLabel output_burn2;
    private static Graphics g=null;

    public void init () {
        //INPUT
        this.input_data = new JTextArea("Data", 30, 30);
        JScrollPane data_pane= new JScrollPane(input_data);
        this.input_jmax = new JTextArea("Polya-Tree Levels", 1, 30);
        this.input_gibbs = new JTextArea("Gibbs Iterates", 1, 30);
        this.input_burnin = new JTextArea("Burn-in", 1, 30);


        //OUTPUT
        Dimension D;
        Image start;

        this.output_burn1 = new JLabel();
        D = new Dimension(345,200);
        start = createImage((int) D.getWidth(), (int) D.getHeight());
        g = start.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,345,200);
        output_burn1.setIcon(new ImageIcon(start));

        this.output_burn2 = new JLabel();
        D = new Dimension(345, 200);
        start = createImage((int) D.getWidth(), (int) D.getHeight());
        g = start.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,345,200);
        output_burn2.setIcon(new ImageIcon(start));

        this.output_graph = new JLabel();
        D = new Dimension(700, 200);
        start = createImage((int) D.getWidth(), (int) D.getHeight());
        g = start.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,700,200);
        output_graph.setIcon(new ImageIcon(start));

        //BUTTON
        JButton b = new JButton("Process Data");

        //set size
        setSize(1200, 600);
        setBackground(Color.lightGray);

        //Create Input Side
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(b);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.add(data_pane);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(input_jmax);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(input_gibbs);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(input_burnin);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(buttonPanel);

        //Create Output Side
        JPanel estPanel = new JPanel();
        estPanel.setBackground(Color.LIGHT_GRAY);
        estPanel.add(output_graph);

        JPanel burninPanel = new JPanel();
        burninPanel.setBackground(Color.LIGHT_GRAY);
        burninPanel.setLayout(new BoxLayout(burninPanel, BoxLayout.X_AXIS));
        burninPanel.add(output_burn1);
        burninPanel.add(Box.createHorizontalStrut(10));
        burninPanel.add(output_burn2);

        this.output_text = new JTextArea("",15,1);
        this.output_text.setEditable(false);
        JScrollPane output_pane= new JScrollPane(output_text);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.lightGray);
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
        outputPanel.add(estPanel);
        outputPanel.add(Box.createVerticalStrut(10));
        outputPanel.add(burninPanel);
        outputPanel.add(Box.createVerticalStrut(10));
        outputPanel.add(output_pane);


        this.setVisible(true); 
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(inputPanel)
                        .addComponent(outputPanel)
                        ) 
                );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(inputPanel)
                        .addComponent(outputPanel)
                        )
                );
        this.setLayout(layout);        
        this.setVisible(true);

        // specify that action events sent by the
        // button or the input TextField should be handled 
        // by the same CapitalizerAction object
        Multiplicity ca = new Multiplicity(input_data, input_jmax, input_gibbs, input_burnin, output_text,output_graph,output_burn1,output_burn2);
        b.addActionListener(ca);
    }
}