public class MyConsole implements ActionListener {

    private JFrame frame;
    private JTextArea myText;
    private JTextField userText;
    private String readText;
    private Object sync;        

    /*
     * Main and only constructor
     */
    public MyConsole() {
        // Synchronization object
        sync = new Object();

        // Create a window to display the console
        frame = new JFrame("My Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setContentPane(createUI());
        frame.setVisible(true);
    }

    /*
     * Creates user interface
     */
    private Container createUI() {
        // Create a Panel to add all objects
        JPanel panel = new JPanel (new BorderLayout());

        // Create and set the console 
        myText = new JTextArea();
        myText.setEditable(false);
        myText.setAutoscrolls(true);
        myText.setBackground(Color.LIGHT_GRAY);

        // This will auto scroll the right bar when text is added
        DefaultCaret caret = (DefaultCaret) myText.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        // Create the input for the user
        userText = new JTextField();
        userText.addActionListener(this);

        panel.add(new JScrollPane(myText), BorderLayout.CENTER);
        panel.add(userText, BorderLayout.SOUTH);

        return panel;
    }

    /*
     * Waits until a value is typed in the console and returns it
     */
    public String read(){
        print("==>");

        synchronized (sync) {
            try {
                sync.wait();
            } catch (InterruptedException e) {
                return readText = "";
            }
        }   
        return readText;
    }

    /*
     * Prints s
     */
    public synchronized void print(String s){
        // Add the "s" string to the console and 
        myText.append(s);
    }

    /*
     * Prints s and a new line
     */
    public synchronized void println(String s){
        this.print(s + "\r\n");
    }

    /*
     * Close the console
     */
    public void closeConsole(){
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Check if the input is empty
        if ( !userText.getText().equals("") ){
            readText = userText.getText();          
            println(" " + readText);
            userText.setText("");
            synchronized (sync) {
                sync.notify();
            }
        }           
    }
}