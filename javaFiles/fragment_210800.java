import ...

public class mainUserInterface {

private JFrame frame;
private JPanel mainPanel;
private  JPanel commandsPanel;
private JScrollPane commandsScrollPane;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                mainUserInterface window = new mainUserInterface();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the application.
 */
public mainUserInterface() {
    initialize();
}

private void initialize() {

    frame = new JFrame("CommandsExecutor");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(1000, 700));

    mainPanel = new JPanel(new BorderLayout(5,5));
    mainPanel.setBorder( new TitledBorder("") );


    commandsPanel = new JPanel();
    commandsPanel.setLayout(new BoxLayout(commandsPanel, BoxLayout.Y_AXIS));

    for(int i=0; i<15;i++){

        commandsPanel.add(new CommandPanel());
    }

    commandsScrollPane = new JScrollPane(commandsPanel);
    mainPanel.add(commandsScrollPane,BorderLayout.CENTER);


    frame.setContentPane(mainPanel);
    frame.pack();
    frame.setVisible(true);
}
}